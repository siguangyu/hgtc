package com.yys.utils;


import com.yys.exception.HgtcException;
import com.yys.response.GenericResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

import static com.yys.common.MsgConstants.MSG_SUCCESS;


@Component
public class ResponseUtils {

	private static ResponseUtils responseUtils;
	
	@Autowired
	private MessageSource messageSource;
	
	@PostConstruct
	public void init() {
		responseUtils = this;
		responseUtils.messageSource = this.messageSource;
	}
	
	public static String getMessage(String code, String...args) {
	    if (StringUtils.isBlank(code)) {
	        return "";
	    }
	    return responseUtils.messageSource.getMessage(code, args, Locale.CHINA);
	}

	public static GenericResponse genSuccessResponse(){
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setCode(MSG_SUCCESS);
		genericResponse.setMessage(responseUtils.messageSource.getMessage(MSG_SUCCESS,null,Locale.CHINA));
		return genericResponse;
	}

	public static GenericResponse genSuccessResponse(Object data){
		GenericResponse genericResponse = genSuccessResponse();
		genericResponse.setData(data);
		return genericResponse;
	}

	public static GenericResponse genSuccessResponse(String code, String...args) {
		
		GenericResponse genericResponse = new GenericResponse();
		
		code = StringUtils.isEmpty(code) ? MSG_SUCCESS : code;
		args = args.length == 0 ? new String[] {""} : args;
		
		String message = responseUtils.messageSource.getMessage(code, args, Locale.CHINA);
		
		genericResponse.setCode(code);
		genericResponse.setMessage(message);

		return genericResponse;
	}
	
	public static GenericResponse genErrorResponse(String code, String...args) {
		GenericResponse genericResponse = new GenericResponse();
		
		String message = responseUtils.messageSource.getMessage(code, args, Locale.CHINA);
		
		genericResponse.setCode(code);
		genericResponse.setMessage(message);
		
		return genericResponse;
	}
	
    public static GenericResponse genErrorResponse(HgtcException e) {
        GenericResponse genericResponse = new GenericResponse();

        genericResponse.setCode(e.getCode());
        genericResponse.setMessage(getMessage(e.getCode(), e.getArgs()));

        return genericResponse;
    }
    
    public static HgtcException genPorkException(String code, String...args) {
        return new HgtcException(code, args);
    }
}
