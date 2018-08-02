package cn.jiang.jboot.service;

import cn.jiang.jboot.base.JbootBaseService;
import cn.jiang.jboot.entity.Role;

import java.util.List;

/**
 * 角色接口
 * @author jiang
 */
public interface RoleService extends JbootBaseService<Role,String> {

    /**
     * 获取默认角色
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
