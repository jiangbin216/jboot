package cn.jiang.jboot.service.elasticsearch;

import cn.jiang.jboot.common.vo.SearchVo;
import cn.jiang.jboot.entity.elasticsearch.EsLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author jiang
 */
public interface EsLogService {

    /**
     * 添加日志
     * @param esLog
     * @return
     */
    EsLog saveLog(EsLog esLog);

    /**
     * 通过id删除日志
     * @param id
     */
    void deleteLog(String id);

    /**
     * 删除全部日志
     */
    void deleteAll();

    /**
     * 分页获取全部日志
     * @param pageable
     * @return
     */
    Page<EsLog> getLogList(Pageable pageable);

    /**
     * 分页搜索获取日志
     * @param key
     * @param searchVo
     * @param pageable
     * @return
     */
    Page<EsLog> searchLog(String key, SearchVo searchVo, Pageable pageable);
}
