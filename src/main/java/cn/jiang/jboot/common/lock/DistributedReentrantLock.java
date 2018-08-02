package cn.jiang.jboot.common.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author jiang
 */
public interface DistributedReentrantLock {

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException;

    public void unlock();
}
