package cn.jiang.jboot.dao;

import cn.jiang.jboot.entity.Role;
import cn.jiang.jboot.entity.UserRole;
import cn.jiang.jboot.base.JbootBaseDao;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 用户角色数据处理层
 * @author jiang
 */
public interface UserRoleDao extends JbootBaseDao<UserRole,String> {

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
