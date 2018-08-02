package cn.jiang.jboot.service;

import cn.jiang.jboot.base.JbootBaseService;
import cn.jiang.jboot.entity.RolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 角色权限接口
 * @author jiang
 */
public interface RolePermissionService extends JbootBaseService<RolePermission,String> {

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