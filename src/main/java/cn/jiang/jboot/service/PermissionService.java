package cn.jiang.jboot.service;

import cn.jiang.jboot.base.JbootBaseService;
import cn.jiang.jboot.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 权限接口
 * @author jiang
 */
public interface PermissionService extends JbootBaseService<Permission,String> {

    /**
     * 通过层级查找
     * 默认升序
     * @param level
     * @return
     */
    List<Permission> findByLevelOrderBySortOrder(Integer level);

    /**
     * 通过parendId查找
     * @param parentId
     * @return
     */
    List<Permission> findByParentIdOrderBySortOrder(String parentId);

    /**
     * 通过类型和层级查找
     * @param level
     * @param type
     * @return
     */
    List<Permission> findByLevelAndTypeOrderBySortOrder(Integer level, Integer type);

    /**
     * 通过parendId和类型查找
     * @param type
     * @param parentId
     * @return
     */
    List<Permission> findByTypeAndParentIdOrderBySortOrder(Integer type, String parentId);
}