package com.sysu.course.common.util;

public class Result {

    /**成功：{\"success\":true,\"error_code\":\"\",\"data\":%s}**/
    public static final String RESULT_SUCCEED ="{\"success\":true,\"error_code\":\"\",\"data\":%s}";

    /**失败：{\"success\":true,\"error_code\":\"\",\"data\":%s}**/
    public static final String RESULT_FAIL =  "{\"success\":false,\"error_code\":\"%s\",\"data\":[]}";


    /**失败,带错误信息：{\"success\":true,\"error_code\":\"\",\"data\":%s}**/
    public static final String RESULT_FAIL_MS =  "{\"success\":false,\"error_code\":\"%s\",\"data\":[{message:\"%s\"}]}";

}