package com.xr.service;

import com.xr.entity.Role;
import com.xr.entity.Users;
import com.xr.mapper.UsersMapper;

import java.util.List;

public interface UsersService{
    /**
     * 用户登录
     * @param users
     * @return
     */
    public Users login(Users users);

    public List<String> findUserRoles(String username);

    public Users findUserByUserName(String username);

    public void add(Users users);

    public void delete(Long id);

    public Users queryById(int id);

    public void update(Users users);

    public List<Users> list(Users users);

    public List<Role>  findUserByRoless(String username);

}
