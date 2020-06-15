package com.xr.service.impl;

import com.xr.entity.Role;
import com.xr.entity.Users;
import com.xr.mapper.UsersMapper;
import com.xr.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users login(Users users) {
        System.out.println(users+"用户");
        return usersMapper.findByNameAndPassword(users);
    }

    @Override
    public List<String> findUserRoles(String username) {
        return usersMapper.findUserRoles(username);
    }

    @Override
    public Users findUserByUserName(String username) {
        return usersMapper.findUserByUserName(username);
    }

    @Override
    public void add(Users users) {
        usersMapper.add(users);
    }

    @Override
    public void delete(Long id) {
        usersMapper.delete(id);
    }

    @Override
    public Users queryById(int id) {
        return usersMapper.queryById(id);
    }

    @Override
    public void update(Users users) {
        usersMapper.update(users);
    }

    @Override
    public List<Users> list(Users users) {
        return usersMapper.list(users);
    }

    @Override
    public List<Role> findUserByRoless(String username) {
        return usersMapper.findUserByRoless(username);
    }

}
