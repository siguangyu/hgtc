/**
 * 
 */
package com.yys.exception;

/**
 * 业务异常类<br>
 * 所有Service抛出的运行时异常以此为标准
 */
public class HgtcException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String code;
    private String[] args;
//    private String msg;
    
    protected HgtcException() {
        super();
    }
    
    public HgtcException(String code, String... args) {
        super(code);
        this.code = code;
        this.args = args;
    }

    
    
    public String getCode() {
        return code;
    }
    
    public String[] getArgs() {
        return args;
    }

}
