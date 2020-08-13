package com.yys.response; /**
 * @author Sigy
 * @date 2020/6/30 16:06
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sigy
 * @date 2020/6/30 16:06
 */
@Data
public class MemberResponse implements Serializable{
    private Integer id;
    private String yysName;
    private String token;
}
