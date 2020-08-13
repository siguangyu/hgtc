package com.yys.common;

import org.springframework.stereotype.Component;

/**
 * 消息Code常量类
 */
@Component
public class MsgConstants {

    public static final String MSG_SUCCESS = "000000";

    // 传参校验相关 begin
    public static final String MSG_FAIL = "400000";
    public static final String MSG_NOT_NULL = "400001";
    public static final String MSG_FORMAT_ERR = "400002";
    public static final String MSG_LENGTH_TOO_LONG = "400003";
    public static final String MSG_PARAM_INVALID = "400004";
    public static final String MSG_MUST_INTEGER = "400005";
    public static final String MSG_OVER_LENGTH = "400006";
    public static final String MSG_MUST_NOT_NEGATIVE = "400007";
    public static final String MSG_DATA_ERR = "400008";
    public static final String MSG_MUST_POSITIVE = "400009";
    public static final String MSG_MUST_LESS = "400010";
    public static final String MSG_TIME_PAST = "400011";
    public static final String MSG_TIME_FUTURE = "400012";
    public static final String MSG_TIME_MUST_AFTER = "400013";
    public static final String MSG_TIME_MUST_BEFORE = "400014";
    public static final String MSG_MUST_BE_TRUE = "400015";
    public static final String MSG_MUST_BE_FALSE = "400016";
    public static final String MSG_SENSITIVE_WORDS = "400017";
    //    public static final String MSG_PHONE_ERROR = "400018";
    public static final String MSG_TIME_FORMAT_ERROR = "400019";
    public static final String MSG_TIME_PARSE_ERROR = "400020";
    public static final String MSG_MUST_NULL = "400021";
    public static final String MSG_SIZE_OVER = "400023";
    public static final String MSG_PHONE_OVER_SIZE="400022";
    public static final String MSG_PARAM_NOT_REPEAT="400024";
    public static final String MSG_OPERATION_NOT_ALLOW="400025";

    // 传参校验相关 end
    public static final String MSG_NOT_DELETE_NONEMPTY_GROUPS = "410001";
    public static final String MSG_DATA_ALREADY_EXISTS = "410002";

    //文件相关
    public static final String MSG_FILE_FORMAT_ERROR = "420001";
    public static final String MSG_FILE_CONTENT_ERROR = "420002";
    public static final String MSG_FILE_IS_NULL = "420003";
    public static final String MSG_FILE_PATH_IS_NULL = "420004";
    public static final String MSG_FILE_NOT_EXIST = "420005";
    public static final String MSG_FILE_OVER_SIZE = "420006";
    public static final String MSG_FILE_UPLOAD_FAIL = "420007";
    public static final String MSG_FILE_DOWNLOAD_FAIL = "420008";
    public static final String MSG_FILE_DELETE_FAIL = "420009";
    public static final String MSG_FILE_CONTENT_ERROR_2 = "420010";
    public static final String MSG_FILE_OUT_OF_LIMIT = "420011";
    public static final String MSG_FILE_NOT_VIDEO = "420012";
    public static final String MSG_FILE_NOT_PIC = "420013";

    public static final String MSG_NO_MAINTENANCE_USER = "430001";


    //钉钉错误
    public static final String MSG_ACCOUNT_EXCEPTION = "500001";

    public static final String MSG_NOT_LOGIN = "500002";
    public static final String MSG_FAIL_LOGIN = "500003";
    public static final String MSG_ACCOUNT_NOT_EXISTS = "500004";


    // service begin
    /**
     * 排他锁错误码
     */
    public static final String MSG_METHOD_ANNO_NOT_ADD = "510001";
    public static final String MSG_PARAM_ANNO_NOT_ADD = "510002";
    public static final String MSG_LOCK_CONFLICT = "510003";
    // service end


    public static final String MSG_SYSTEM_ERR = "511001";
    public static final String MSG_USER_VERIFY_ERR = "511002";
    public static final String MSG_NO_RIGHT = "511003";
    public static final String NO_BELONG_HOUSE = "511003";

}
