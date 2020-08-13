package com.yys.utils;

import java.util.UUID;

public class UniqueIdUtils {

    /**
     * 生成唯一值：uuid末尾12字符+时间戳
     *
     * @return
     */
    public static String createUniqueId() {
        String uniqueId = UUID.randomUUID().toString();
        uniqueId = uniqueId.substring(uniqueId.lastIndexOf("-") + 1, uniqueId.length());
        uniqueId = uniqueId + System.currentTimeMillis();
        return uniqueId;
    }

    /**
     * 根据唯一值，获得生成日期 yyyyMMdd
     *
     * @param uniqueId
     * @return
     */
    public static String getIntDateFromUniqueId(String uniqueId) {
        String date = null;
        try {
            long timestamp = Long.parseLong(uniqueId.substring(12));
            date = TimeUtils.ofEpochMilli(timestamp).substring(0, 10);
            date = date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 根据唯一值，获得生成日期时间 yyyy-MM-dd HH:mm:ss
     *
     * @param uniqueId
     * @return
     */
    public static String getDateTimeFromUniqueId(String uniqueId) {
        String datetime = null;
        try {
            long timestamp = Long.parseLong(uniqueId.substring(12));
            datetime = TimeUtils.ofEpochMilli(timestamp);
        } catch (Exception e) {
        }
        return datetime;
    }

    /**
     * 判断是否是合法的唯一值
     *
     * @param uniqueId
     * @return
     */
    public static boolean isLegalUniqueId(String uniqueId) {
        boolean result = false;
        String timestamp = uniqueId.substring(12);
        try {
            if (CheckUtils.isNumber(timestamp)) {
                String date = TimeUtils.ofEpochMilli(Long.parseLong(timestamp)).substring(0, 10);
                if (CheckUtils.isDate(date)) {
                    result = true;
                }
            }
        } catch (Exception e) {
        }
        return result;
    }
}
