package cn.jiang.jboot.config.security;

import cn.jiang.jboot.common.annotation.SystemLog;
import cn.jiang.jboot.common.utils.ResponseUtil;
import cn.jiang.jboot.entity.User;
import cn.jiang.jboot.exception.LoginFailLimitException;
import cn.jiang.jboot.service.UserService;
import cn.jiang.jboot.service.mybatis.IPermissionService;
import cn.hutool.core.util.StrUtil;
import cn.jiang.jboot.config.security.SecurityUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author jiang
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    @Value("${jboot.loginAfterTime}")
    private Integer loginAfterTime;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String flagKey = "loginFailFlag:"+username;
        String value = redisTemplate.opsForValue().get(flagKey);
        if(StrUtil.isNotBlank(value)){
            //超过限制次数
            throw new LoginFailLimitException("登录错误次数超过限制，请"+loginAfterTime+"分钟后再试");
        }
        User user = userService.findByUsername(username);
        return new SecurityUserDetails(user);
    }
}
