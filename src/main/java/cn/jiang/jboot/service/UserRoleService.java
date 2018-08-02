package cn.jiang.jboot.service;

import cn.jiang.jboot.dao.RoleDao;
import cn.jiang.jboot.entity.Role;
import cn.jiang.jboot.base.JbootBaseService;
import cn.jiang.jboot.entity.UserRole;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 用户角色接口
 * @author jiang
 */
public interface UserRoleService extends JbootBaseService<UserRole,String> {

    /**
     * 通过roleId查找
     * @param roleId
     * @return
     */
    List<UserRole> findByRoleId(String roleId);

    /**
     * 删除用户角色
     * @param userId
     */
    void deleteByUserId(String userId);
}
