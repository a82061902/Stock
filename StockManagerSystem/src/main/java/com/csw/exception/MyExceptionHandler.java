package com.csw.exception;

import com.csw.common.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//全局异常处理
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> myHandler(Exception e){
        return Result.fail("系统错误："+e.getMessage());
    }
}
