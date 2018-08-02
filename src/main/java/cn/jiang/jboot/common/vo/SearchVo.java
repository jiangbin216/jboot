package cn.jiang.jboot.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiang
 */
@Data
public class SearchVo implements Serializable {

    private String startDate;

    private String endDate;
}
