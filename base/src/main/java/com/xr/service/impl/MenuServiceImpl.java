package com.xr.service.impl;

import com.xr.entity.Menu;
import com.xr.mapper.MenuMapper;
import com.xr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findRoleMenus(String name) {
        return menuMapper.findRoleMenus(name);
    }
}
