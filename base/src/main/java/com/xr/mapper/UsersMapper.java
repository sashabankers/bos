package com.xr.mapper;

import com.xr.entity.Role;
import com.xr.entity.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersMapper {

    @Select("select id,username,password from sys_user where username = #{username} and password=#{password}")
    public Users findByNameAndPassword(Users loginUsers);

    public List<String> findUserRoles(String username);

    @Select("select id,username,password,salt from sys_user where username = #{username}")
    public Users findUserByUserName(String username);

    @Insert("insert into sys_user(username,password) values(#{username},#{password})")
    public void add(Users users);

    @Delete("delete from sys_user where id=#{id}")
    public void delete(Long id);

    @Select("select *from sys_user where id=#{id}")
    public Users queryById(int id);

    @Update("update sys_user set username=#{username},password=#{password} where id=#{id}")
    public void update(Users users);

    @Select("select *from sys_user")
    public List<Users> list(Users users);

    @Select("SELECT r.name from sys_user u,sys_role r,sys_user_role ur\n" +
            "    where r.id = ur.role_id and u.username=#{username} and ur.user_id=u.id")
    public List<Role>  findUserByRoless(String username);
}
