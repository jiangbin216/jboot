package cn.jiang.jboot.common.lock;

/**
 * 分布式锁模板类
 * @author jiang
 */
public interface DistributedLockTemplate {

    /**
     * @param lockId 锁id(对应业务唯一ID)
     * @param timeout 单位毫秒
     * @param callback 回调函数
     * @return
     */
    public Object execute(String lockId, Integer timeout, Callback callback);
}
