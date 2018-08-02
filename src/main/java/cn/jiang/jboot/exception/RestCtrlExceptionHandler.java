package cn.jiang.jboot.exception;

import cn.jiang.jboot.common.utils.ResultUtil;
import cn.jiang.jboot.common.vo.Result;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jiang
 */
@Slf4j
@RestControllerAdvice
public class RestCtrlExceptionHandler {

    @ExceptionHandler(cn.jiang.jboot.exception.JbootException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result<Object> handleXCloudException(cn.jiang.jboot.exception.JbootException e) {
        String errorMsg="Jboot exception";
        if (e!=null){
            errorMsg=e.getMsg();
            log.warn(e.toString());
        }
        return new ResultUtil<>().setErrorMsg(500, errorMsg);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result<Object> handleException(Exception e) {
        String errorMsg="Exception";
        if (e!=null){
            errorMsg=e.getMessage();
            log.warn(e.toString());
        }
        return new ResultUtil<>().setErrorMsg(500, errorMsg);
    }
}
