package cn.jiang.jboot.dao;

import cn.jiang.jboot.base.JbootBaseDao;
import cn.jiang.jboot.entity.User;
import cn.jiang.jboot.base.JbootBaseDao;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * 用户数据处理层
 * @author jiang
 */
public interface UserDao extends JbootBaseDao<User,String> {

    /**
     * 通过用户名和状态获取用户
     * @param username
     * @param status
     * @return
     */
    List<User> findByUsernameAndStatus(String username, Integer status);

    /**
     * 通过状态和类型获取用户
     * @param status
     * @param type
     * @return
     */
    List<User> findByStatusAndType(Integer status, Integer type);
}
