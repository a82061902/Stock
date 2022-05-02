package com.csw.pojo;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AesDecrypt {
    @Select("SELECT AES_DECRYPT(from_base64(`password`),'salt')FROM role WHERE username=#{username} ")
    String getRolePasswordByDecode(String username);
}
