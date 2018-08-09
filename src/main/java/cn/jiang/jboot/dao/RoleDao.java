package cn.jiang.jboot.dao;

import cn.jiang.jboot.base.JbootBaseDao;
import cn.jiang.jboot.entity.Role;

import java.util.List;

/**
 * 角色数据处理层
 * @author jiang
 */
public interface RoleDao extends JbootBaseDao<Role,String> {

    /**
     * 获取默认角色
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
