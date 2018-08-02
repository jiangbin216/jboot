package cn.jiang.jboot.service;

import cn.jiang.jboot.base.JbootBaseService;
import cn.jiang.jboot.common.vo.SearchVo;
import cn.jiang.jboot.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户接口
 * @author jiang
 */
@CacheConfig(cacheNames = "user")
public interface UserService extends JbootBaseService<User,String> {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    @Cacheable(key = "#username")
    User findByUsername(String username);

    /**
     * 通过状态和类型获取用户
     * @param status
     * @param type
     * @return
     */
    List<User> findByStatusAndType(Integer status, Integer type);

    /**
     * 多条件分页获取用户
     * @param user
     * @param searchVo
     * @param pageable
     * @return
     */
    Page<User> findByCondition(User user, SearchVo searchVo, Pageable pageable);
}
