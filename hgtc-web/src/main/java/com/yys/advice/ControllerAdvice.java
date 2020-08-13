package com.yys.advice;

import com.google.common.base.Throwables;
import com.yys.common.MsgConstants;
import com.yys.exception.HgtcException;
import com.yys.response.GenericResponse;
import com.yys.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;

/**
 * 针对所有RequestMapping请求处理的一些统一处理，包括String参数去空格以及统一的异常处理返回
 */
@RestControllerAdvice(basePackages = {"com.yys.controller"})
@Slf4j
public class ControllerAdvice {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 对url请求参数，如果是String类型，则去除2边空格
        boolean emptyAsNull = true;// 字符串trim之后是""的话，返回null
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(emptyAsNull);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }

    /**
     * Controller中捕获到ParkException后的统一处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HgtcException.class,Exception.class})
    public GenericResponse HgtcExceptionHandler(HgtcException e) {
        GenericResponse genericResponse = ResponseUtils.genErrorResponse(e);

        return genericResponse;
    }

/*
    @ExceptionHandler(ConstraintViolationException.class)
    public GenericResponse constrainViolationExceptionHandler(ConstraintViolationException exception) {
        GenericResponse genericResponse = new GenericResponse();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            String code = item.getConstraintDescriptor().getAnnotation().annotationType().getCanonicalName();
            code = code.substring(code.lastIndexOf(".")+1);
            String message = item.getMessage();
            //todo:其他校验类型
            switch (code) {
                case "NotNull":
                case "NotEmpty":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, message);
                    break;
                default:
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
                    break;
            }
        }
        return genericResponse;
    }*/

    @ExceptionHandler(BindException.class)
    public GenericResponse bindingExceptionHandler(BindException exception){

        return disposeFieldError(exception.getFieldError());
    }




    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        return disposeFieldError(fieldError);

    }


    private GenericResponse disposeFieldError(FieldError fieldError){
        GenericResponse genericResponse;

        String code = fieldError.getCode();
        if (StringUtils.isBlank(code)) {
            genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
        } else {
            switch (code) {
                case "ScriptAssert":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, fieldError.getDefaultMessage());
                    break;
                case "Null":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_MUST_NULL, fieldError.getDefaultMessage());
                    break;
                case "NotNull":
                case "NotEmpty":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, fieldError.getDefaultMessage());
                    break;
                case "AssertTrue":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_MUST_BE_TRUE);
                    break;
                case "AssertFalse":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_MUST_BE_FALSE);
                    break;
                case "Min":
                case "DecimalMin":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_MUST_POSITIVE, fieldError.getDefaultMessage(), fieldError.getArguments()[1].toString());
                    break;
                case "Max":
                case "DecimalMax":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_MUST_LESS, fieldError.getDefaultMessage(), fieldError.getArguments()[1].toString());
                    break;
                case "Size":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_SIZE_OVER, fieldError.getDefaultMessage(), fieldError.getArguments()[2].toString(),fieldError.getArguments()[1].toString());
                    break;
                case "Digits":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_FORMAT_ERR, fieldError.getDefaultMessage(), fieldError.getArguments()[1].toString());
                    break;
                case "Past":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_TIME_PAST, fieldError.getDefaultMessage());
                    break;
                case "Future":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_TIME_FUTURE, fieldError.getDefaultMessage());
                    break;
                case "TimeAfter":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_TIME_MUST_AFTER, fieldError.getDefaultMessage());
                    break;
                case "TimeBefore":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_TIME_MUST_BEFORE, fieldError.getDefaultMessage());
                    break;
                case "Pattern":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_FORMAT_ERR, fieldError.getDefaultMessage(), fieldError.getArguments()[1].toString());
                    break;
                case "SensitiveWord":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_SENSITIVE_WORDS, fieldError.getDefaultMessage());
                    break;
                case "Range":
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_PARAM_INVALID,fieldError.getDefaultMessage(),fieldError.getArguments()[2].toString(),fieldError.getArguments()[1].toString());
                    break;
                default:
                    log.error(fieldError.toString());
                    genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
                    break;
            }
        }
        return genericResponse;
    }

    /**
     * Controller中捕获到Exception后的统一处理
     *
     * @param e
     * @return
     */
   /* @ExceptionHandler(Exception.class)
    public GenericResponse exceptionHandler(Exception e) {
        log.error("控制层捕捉到系统异常: " + Throwables.getStackTraceAsString(e));
        GenericResponse genericResponse = ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
        return genericResponse;
    }*/
}
