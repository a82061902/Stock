package com.csw.service.impl;

import com.csw.entity.MyUserDetails;
import com.csw.mapper.MyUserDetailsServiceMapper;
import com.csw.pojo.AesDecrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    MyUserDetailsServiceMapper userDetailsServiceMapper;
    @Autowired
    HttpSession session;
    @Resource
    AesDecrypt aesDecrypt;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserDetails myUserDetails=userDetailsServiceMapper.findByUserName(username);

        /*控制台报Encoded password does not look like BCrypt异常，这是因为Spring Security会把前台传来的字段加密，
        我们在自定义逻辑时，因为数据库里是明文，所以在查数据库时也应该进行encode加密*/
       /* 这里我通过AesDecrypt类中调用了mysql的AES_DECRYPT函数解密，因为在添加用户时传入数据库的密码时也是通过数据库的函数对密码进行过AES加密，等于还原成了明文在给SprintSecurity加密。
           因为数据库存储不是明文所以才有这一步操作。*/
        String decodePassword=aesDecrypt.getRolePasswordByDecode(myUserDetails.getUsername());
        myUserDetails.setPassword(decodePassword);
        myUserDetails.setPassword(new BCryptPasswordEncoder().encode(myUserDetails.getPassword()));


        if(myUserDetails==null)throw new UsernameNotFoundException("用户名不存在");
        else if(!myUserDetails.isEnabled()){session.setAttribute("enabled","true");throw new LockedException("用户被锁定，请联系管理员");}

        //传递用户名用于首页回显
        session.setAttribute("username",username);

        //获得用户权限并转换成GrantedAuthority类
        String authority =userDetailsServiceMapper.findAuthByUserName(username);
        myUserDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(authority));

        return myUserDetails;
    }
}
