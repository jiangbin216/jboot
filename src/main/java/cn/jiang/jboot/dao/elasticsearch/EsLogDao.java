package cn.jiang.jboot.dao.elasticsearch;

import cn.jiang.jboot.entity.elasticsearch.EsLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author jiang
 */
public interface EsLogDao extends ElasticsearchRepository<EsLog, String> {

}
