package com.yys.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * web层通用返回对象
 * 
 * @author
 *
 */
@SuppressWarnings("rawtypes")
@Getter
@Setter
public class GenericResponse implements Serializable {

    /**
     * Serial version UID for the class to uniquely identify the object during
     * serialization process
     */
    public static final long serialVersionUID = 1L;
    
    /**
     * A String containing response code.
     */
    @JsonProperty(index=1)
    private String code;
    
    /**
     * A String containing message.
     */
    @JsonProperty(index=2)
    private String message;
    
    /**
     * An data object that contains the actual objects
     */
    @JsonProperty(index=6)
    private Object data;

    public GenericResponse() {
    }

}
