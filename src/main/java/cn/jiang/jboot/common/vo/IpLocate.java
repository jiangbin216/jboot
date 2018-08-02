package cn.jiang.jboot.common.vo;

import cn.jiang.jboot.common.vo.City;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiang
 */
@Data
public class IpLocate implements Serializable {

    private String retCode;

    private City result;
}

