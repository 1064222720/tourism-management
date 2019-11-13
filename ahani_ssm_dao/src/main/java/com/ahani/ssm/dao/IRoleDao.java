package com.ahani.ssm.dao;

import com.ahani.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(id = true,property = "roleName",column = "roleName"),
            @Result(id = true,property = "roleDesc",column = "roleDesc"),
            @Result(id = true,property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select="com.ahani.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(Integer userId) throws Exception;


    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;
}
