package cn.jiang.jboot.common.lock;

/**
 * @author jiang
 */
public interface Callback {

    /**
     * 成功获取锁后执行方法
     * @return
     * @throws InterruptedException
     */
    public Object onGetLock() throws InterruptedException;

    /**
     * 获取锁超时回调
     * @return
     * @throws InterruptedException
     */
    public Object onTimeout() throws InterruptedException;
}
