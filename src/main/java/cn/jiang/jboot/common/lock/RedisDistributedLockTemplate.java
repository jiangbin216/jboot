package cn.jiang.jboot.common.lock;

import cn.jiang.jboot.common.lock.Callback;
import cn.jiang.jboot.common.lock.DistributedLockTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import java.util.concurrent.TimeUnit;

/**
 * @author jiang
 */
@Slf4j
@Component
public class RedisDistributedLockTemplate implements DistributedLockTemplate {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public Object execute(String lockId, Integer timeout, Callback callback) {

        cn.jiang.jboot.common.lock.RedisReentrantLock distributedReentrantLock = null;
        boolean getLock=false;
        try {
            distributedReentrantLock = new cn.jiang.jboot.common.lock.RedisReentrantLock(jedisPool,lockId);
            if(distributedReentrantLock.tryLock(new Long(timeout), TimeUnit.MILLISECONDS)){
                getLock=true;
                return callback.onGetLock();
            }else{
                return callback.onTimeout();
            }
        }catch(InterruptedException ex){
            log.error(ex.getMessage(), ex);
            Thread.currentThread().interrupt();
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        }finally {
            if(getLock) {
                distributedReentrantLock.unlock();
            }
        }
        return null;
    }
}
