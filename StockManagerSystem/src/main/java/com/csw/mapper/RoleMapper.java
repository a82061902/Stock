package com.csw.mapper;

import com.csw.common.vo.RoleQuery;
import com.csw.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("<script>"+
            "SELECT * FROM stockmanager.role" +
            "<where><if test='username!= null'> and username like CONCAT('%',#{username},'%') </if></where>" +
            "limit #{start},#{limit}"
            +"</script>")
    List<Role> getRolesByParam(RoleQuery param);

    @Select("SELECT count(1) FROM stockmanager.role")
    Long getCounts();

    @Insert("INSERT INTO stockmanager.role(username,password,authorities,enabled) VALUES (#{username}, to_base64(AES_ENCRYPT(#{password},'salt')), #{authorities}, 1)")
    void addRole(Role role);
   // to_base64(AES_ENCRYPT("123","salt")
    @Delete("DELETE FROM stockmanager.role WHERE username=#{username}")
    void deleteRoleByUserName(String username);

    @Update("UPDATE stockmanager.role SET enabled=#{enabled} WHERE username=#{username}")
    void changeEnabled(RoleQuery param);

    @Update("UPDATE stockmanager.role SET authorities=#{authorities} WHERE username=#{username}")
    void changeAuth(String username, String authorities);

}
