package cn.jiang.jboot.serviceimpl;

import cn.jiang.jboot.common.constant.CommonConstant;
import cn.jiang.jboot.common.vo.SearchVo;
import cn.jiang.jboot.dao.UserDao;
import cn.jiang.jboot.dao.UserRoleDao;
import cn.jiang.jboot.dao.mapper.PermissionMapper;
import cn.jiang.jboot.dao.mapper.UserRoleMapper;
import cn.jiang.jboot.entity.Permission;
import cn.jiang.jboot.entity.Role;
import cn.jiang.jboot.entity.User;
import cn.jiang.jboot.service.UserService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户接口实现
 * @author jiang
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDao getRepository() {
        return userDao;
    }

    @Override
    public User findByUsername(String username) {
        
        List<User> list=userDao.findByUsernameAndStatus(username, CommonConstant.USER_STATUS_NORMAL);
        if(list!=null&&list.size()>0){
            User user = list.get(0);
            List<Role> roleList = userRoleMapper.findByUserId(user.getId());
            user.setRoles(roleList);
            List<Permission> permissionList = permissionMapper.findByUserId(user.getId());
            user.setPermissions(permissionList);
            return user;
        }
        return null;
    }

    @Override
    public List<User> findByStatusAndType(Integer status, Integer type) {

        return userDao.findByStatusAndType(status, type);
    }

    @Override
    public Page<User> findByCondition(User user, SearchVo searchVo, Pageable pageable) {

        return userDao.findAll(new Specification<User>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                Path<String> usernameField = root.get("username");
                Path<String> mobileField = root.get("mobile");
                Path<String> emailField = root.get("email");
                Path<Integer> sexField=root.get("sex");
                Path<Integer> typeField=root.get("type");
                Path<Integer> statusField=root.get("status");
                Path<Date> createTimeField=root.get("createTime");

                List<Predicate> list = new ArrayList<Predicate>();

                //模糊搜素
                if(StrUtil.isNotBlank(user.getUsername())){
                    list.add(cb.like(usernameField,'%'+user.getUsername()+'%'));
                }
                if(StrUtil.isNotBlank(user.getMobile())){
                    list.add(cb.like(mobileField,'%'+user.getMobile()+'%'));
                }
                if(StrUtil.isNotBlank(user.getEmail())){
                    list.add(cb.like(emailField,'%'+user.getEmail()+'%'));
                }

                //性别
                if(user.getSex()!=null){
                    list.add(cb.equal(sexField, user.getSex()));
                }
                //类型
                if(user.getType()!=null){
                    list.add(cb.equal(typeField, user.getType()));
                }
                //状态
                if(user.getStatus()!=null){
                    list.add(cb.equal(statusField, user.getStatus()));
                }
                //创建时间
                if(StrUtil.isNotBlank(searchVo.getStartDate())&&StrUtil.isNotBlank(searchVo.getEndDate())){
                    Date start = DateUtil.parse(searchVo.getStartDate());
                    Date end = DateUtil.parse(searchVo.getEndDate());
                    list.add(cb.between(createTimeField, start, DateUtil.endOfDay(end)));
                }

                Predicate[] arr = new Predicate[list.size()];
                cq.where(list.toArray(arr));
                return null;
            }
        }, pageable);
    }
}
