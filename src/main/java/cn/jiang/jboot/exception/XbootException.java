package cn.jiang.jboot.exception;

import lombok.Data;

/**
 * @author jiang
 */
@Data
public class JbootException extends RuntimeException {

    private String msg;

    public JbootException(String msg){
        super(msg);
        this.msg = msg;
    }
}
