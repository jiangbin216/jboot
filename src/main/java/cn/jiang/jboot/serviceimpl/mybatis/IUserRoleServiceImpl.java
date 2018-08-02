package cn.jiang.jboot.serviceimpl.mybatis;

import cn.jiang.jboot.dao.mapper.UserRoleMapper;
import cn.jiang.jboot.entity.Role;
import cn.jiang.jboot.entity.UserRole;
import cn.jiang.jboot.service.mybatis.IUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiang
 */
@Service
public class IUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findByUserId(String userId) {

        return userRoleMapper.findByUserId(userId);
    }
}
