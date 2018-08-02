package cn.jiang.jboot.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiang
 */
@Data
public class City implements Serializable {

    String country;

    String province;

    String city;
}
