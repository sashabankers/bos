package com.xr.service;

import com.xr.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> findRoleMenus(String name);
}
