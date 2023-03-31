package com.example.demo.exception;

import com.example.demo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * jsr303异常统一处理
 * @author wxd 
 * @create 2022-11-07 13:23
 */
@Slf4j
//扫描地址
@RestControllerAdvice(basePackages = "com.example.demo.controller")
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题：{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        StringBuffer stringBuffer = new StringBuffer();
        bindingResult.getFieldErrors().forEach(item ->{
            //获取错误信息
            String message = item.getDefaultMessage();
            //获取错误的属性名字
            String field = item.getField();
            stringBuffer.append(field + ":" + message + " ");
        });
        return Result.failed(400, stringBuffer + "");

    }

    @ExceptionHandler(value = Throwable.class)
    public Result handleException(Throwable throwable){
        log.error("错误",throwable);
        return Result.failed(400, "系统异常");
    }
}
