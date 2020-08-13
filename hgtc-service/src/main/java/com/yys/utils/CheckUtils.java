package com.yys.utils;

import java.util.regex.Pattern;

/**
 * All page check method
 * @author shanw
 */
public class CheckUtils {

    /**
     * 字符串是否为空
     * @param input
     * @return true:不为空 false:空
     */
    public static boolean isNotEmpty(String input) {
        return input != null && input.length() > 0 ? true : false;
    }

    /**
     * 是否纯数字
     * @param input
     * @return
     */
    public static boolean isNumber(String input) {
        return regMatch("^\\d+$", input);
    }

    /**
     * 是否整数
     * @param input
     * @return
     */
    public static boolean isInteger(String input) {
        return regMatch("^[-\\+]?\\d+$", input);
    }

    /**
     * 是否小数类型
     * @param input
     * @return
     */
    public static boolean isDouble(String input) {
        return regMatch("^[-\\+]?\\d+(\\.\\d+)?$", input);
    }

    /**
     * 是否email地址
     * @param input
     * @return
     */
    public static boolean isEmail(String input) {
        return regMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", input);
    }

    /**
     * 是否url地址正确
     * @param input
     * @return
     */
    public static boolean isUrl(String input) {
        return regMatch("^((https|http|ftp|rtsp|mms)?:\\/\\/)?(([0-9a-z_!~*\\'().&=+\\$%-]+: )?[0-9a-z_!~*\\'().&=+\\$%-]+@)?(([0-9]{1,3}.){3}[0-9]{1,3}|([0-9a-z_!~*\\'()-]+.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].[a-z]{2,6})(:[0-9]{1,4})?((\\/?)|(\\/[0-9a-z_!~*\\'().;?:@&=+\\$,%#-]+)+\\/?)$", input);
    }

    /**
     * 是否邮政编码
     * @param input
     * @return
     */
    public static boolean isZipcode(String input) {
        return regMatch("^\\d{3,6}$", input);
    }

    /**
     * 是否全英文字符
     * @param input
     * @return
     */
    public static boolean isEnglish(String input) {
        return regMatch("^[A-Za-z]+$", input);
    }

    /**
     * 是否是电话
     * @param input
     * @return
     */
    public static boolean isPhone(String input) {
        return regMatch("^((\\d{2,5})[-]{0,1})?(\\d{1,})(-(\\d{3,}))?$", input);
    }

    /**
     * 是否手机号
     * @param input
     * @return
     */
    public static boolean isMobile(String input) {
        return regMatch("^1[3-9]\\d{9}$", input);
    }

    /**
     * 是否中国手机号
     * @param input
     * @return
     */
    public static boolean isCmobile(String input) {
        return regMatch("^\\+861[3-9]\\d{9}$", input);
    }

    /**
     * 是否显示号码格式
     * <p>95号码
     * <p>固话号码 +8657188229992
     * @param input
     * @return
     */
    public static boolean isDisplayNbr(String input) {
        return regMatch("^95\\d{3,10}$", input) || isLandlineNbr(input);
    }

    /**
     * 是否固话号码格式
     * @param input
     * @return
     */
    public static boolean isLandlineNbr(String input) {
        return regMatch("^((10)|(2[0-9])|([3-9]\\d{2}))\\d{7,8}$", input);
    }

    /**
     * 是否sip号码格式
     * @param input
     * @return
     */
    public static boolean isSipNbr(String input) {
        return regMatch("^\\+86788\\d{3,10}$", input);
    }

    // /**
    // * 是否是400免费电话
    // */
    // public static boolean isTollFreeNbr(String input) {
    // return regMatch("^400\\d{7}$", input);
    // }
    /**
     * 是否是区号
     * @param input
     * @return
     */
    public static boolean isAreacode(String input) {
        return regMatch("^\\d{2,5}$", input);
    }

    /**
     * 是否是电话号码
     * @param input
     * @return
     */
    public static boolean isPhonecode(String input) {
        return regMatch("^\\d{1,}$", input);
    }

    /**
     * 是否是分机号
     * @param input
     * @return
     */
    public static boolean isExtensioncode(String input) {
        return regMatch("^(\\d{3,})?$", input);
    }

    /**
     * 是否是QQ号
     * @param input
     * @return
     */
    public static boolean isQQ(String input) {
        return regMatch("^\\d{5,11}$", input);
    }

    /**
     * 是否有空格
     * @param input
     * @return
     */
    public static boolean hasBlank(String input) {
        return regMatch("[\\s\\t]", input);
    }

    public static boolean isDate(String date) {
        return regMatch("^(?!0000)[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", date);
    }

    public static boolean isMonth(String month) {
        return regMatch("^(?!0000)[0-9]{4}-(0[1-9]|1[012])$", month);
    }

    public static boolean isIntDate(String date) {
        return regMatch("^(?!0000)[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", date);
    }

    public static boolean isIntMonth(String month) {
        return regMatch("^(?!0000)[0-9]{4}(0[1-9]|1[012])$", month);
    }

    public static boolean isYear(String year) {
        return regMatch("^(?!0000)[0-9]{4}$", year);
    }

    /**
     * 是否是密码(8-20之间并且不能有空格，且不能为纯数字,并且不能含有 & ' " ! / * , < > % # ?)
     * @param input
     * @return
     */
    public static boolean isPwd(String input) {
//        return input != null && !isNumber(input) && !hasBlank(input) && input.length() >= 8 && input.length() <= 20;
        return regMatch("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$", input);
    }

    /**
     * 是否
     * @param input
     * @return
     */
    public static boolean jiami_pwd(String input) {
        return input != null && !isNumber(input) && !hasBlank(input) && input.length() >= 6;
    }

    /**
     * 判断金额2位 
     * @param input
     * @return
     */
    public static boolean isMoney(String input) {
        return regMatch("", input);
    }

    /**
     * 判断金额4位 TODO
     * @param input
     * @return
     */
    public static boolean isMoney4(String input) {
        return regMatch("", input);
    }

    /**
     * 判断带有特殊字符 true 为字符串不带有特殊字符
     * @param input
     * @return
     */
    public static boolean isspecialchar(String input) {
        return regMatch("^[\\x21-\\x7E]+$", input);
    }

    private static boolean regMatch(String regex, String input) {
        input = input == null ? "" : input;
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        String pwd = "12345678";
        System.out.println(isPwd(pwd));
    }
}
