package cn.jiang.jboot.serviceimpl.mybatis;

import cn.jiang.jboot.dao.mapper.PermissionMapper;
import cn.jiang.jboot.entity.Permission;
import cn.jiang.jboot.service.mybatis.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiang
 */
@Service
public class IPermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper; ;

    @Override
    public List<Permission> findByUserId(String userId) {

        return permissionMapper.findByUserId(userId);
    }

    @Override
    public List<Permission> findByRoleId(String roleId) {

        return permissionMapper.findByRoleId(roleId);
    }
}
