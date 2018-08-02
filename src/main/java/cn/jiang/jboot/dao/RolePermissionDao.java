package cn.jiang.jboot.dao;

import cn.jiang.jboot.base.XbootBaseDao;
import cn.jiang.jboot.entity.RolePermission;

import java.util.List;

/**
 * 角色权限数据处理层
 * @author jiang
 */
public interface RolePermissionDao extends JbootBaseDao<RolePermission,String> {

    /**
     * 通过permissionId获取
     * @param permissionId
     * @return
     */
    List<RolePermission> findByPermissionId(String permissionId);

    /**
     * 通过roleId删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}