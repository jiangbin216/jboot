package cn.jiang.jboot.service;

import cn.jiang.jboot.base.JbootBaseService;
import cn.jiang.jboot.common.vo.SearchVo;
import cn.jiang.jboot.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 日志接口
 * @author jiang
 */
public interface LogService extends JbootBaseService<Log,String> {

    /**
     * 日志搜索
     * @param key
     * @param searchVo
     * @param pageable
     * @return
     */
    Page<Log> searchLog(String key, SearchVo searchVo, Pageable pageable);

    /**
     * 删除所有
     */
    void deleteAll();
}
