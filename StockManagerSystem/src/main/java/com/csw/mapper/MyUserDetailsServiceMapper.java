package com.csw.mapper;

import com.csw.entity.MyUserDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MyUserDetailsServiceMapper {
    @Select("SELECT * FROM stockmanager.role WHERE username=#{username}")
    MyUserDetails findByUserName(String username);

    @Select("SELECT authorities FROM stockmanager.role WHERE username=#{username}")
    String findAuthByUserName(String username);
}
