package com.xr.mapper;

import com.xr.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    @Select("SELECT m.sysmid,m.sysmName,m.sysParentId,m.url,m.perms,m.type,m.icon,m.ordernum from sys_role r,sys_role_menu rm,sys_menu m where r.id=rm.rid AND r.`name`=#{name} AND rm.sysmid=m.sysmid")
    public List<Menu> findRoleMenus(String name);
}
