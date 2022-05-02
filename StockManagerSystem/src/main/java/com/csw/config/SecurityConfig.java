package com.csw.config;

import com.csw.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@EnableWebSecurity //开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;
    @Autowired
    DataSource dataSource;

    //链式编程
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人都可以访问，功能也只有对应有权限的人才能访问到
        // 请求授权的规则
        http.authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/welcome.html").permitAll()
                .antMatchers("/info/**").hasAnyAuthority("0","1","2")
                .antMatchers("/goods/**").hasAnyAuthority("0","1")//.permitAll()//
                .antMatchers("/purchase/**").hasAnyAuthority("0","1")
                .antMatchers("/shipment/**").hasAnyAuthority("0","1")
                .antMatchers("/user/**").hasAuthority("0");

        //解决X-Frame-Options deny问题
        http.headers()
                .frameOptions().sameOrigin()
                .httpStrictTransportSecurity().disable();

        // 没有权限默认会到登录页面,需要开启登录的页面
        // /login页面
        http.formLogin()
                .usernameParameter("username") //传递给UserDetailsService中的username 代表用户的唯一标识 不一定只是用户名 也可以是手机号等
                .passwordParameter("password")
                .loginPage("/loginUI")
                .loginProcessingUrl("/login")
                .failureUrl("/loginUI?error=true")
                .defaultSuccessUrl("/",true);
               // .successForwardUrl("/");
                // successForwardUrl是转发过来的，所以还是登录时的post请求，跳转到首页还会携带login到url 若跳转到controller 但POST方法不支持直接返回页面 要通过controller重定向

        //注销,开启了注销功能,跳到首页
        http.logout()
                .logoutSuccessUrl("/")
                .logoutUrl("/logout");

        // 防止网站工具：get，post
        http.csrf().disable();//关闭csrf功能，登录失败肯定存在的原因
        //开启记住我功能: cookie,默认保存两周,自定义接收前端的参数
        http.rememberMe().rememberMeParameter("rememberMe")
                .tokenRepository(persistentTokenRepository())
                .userDetailsService(myUserDetailsService);


    }

    // 认证，springboot 2.1.x 可以直接使用
    // 密码编码： PasswordEncoder
    // 在spring Secutiry 5.0+ 新增了很多加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //动态角色权限信息加载
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);

        //设置启动的时候，在数据库中创建表格persistent_logins。只有数据库中不存在表格的时候可以使用。默认值是false
        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }


}

