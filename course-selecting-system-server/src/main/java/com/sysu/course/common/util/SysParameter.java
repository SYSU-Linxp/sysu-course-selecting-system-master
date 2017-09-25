package com.sysu.course.common.util;

public class SysParameter {
    public static final int CODE_OK=0;
    public static final int CODE_USERNAMEPWD_ERROR=10;
    public static final int CODE_USERTOKEN_ERROR=11;
    public static final int CODE_FORMAT_ERROR=12;

    private static String stationId;
    private static String stationName;

    private static String webserviceId;
    private static String webservicePasswd;

    public static String getStationId() {
        return stationId;
    }
    public static void setStationId(String stationId) {
        SysParameter.stationId = stationId;
    }
    public static String getStationName() {
        return stationName;
    }
    public static void setStationName(String stationName) {
        SysParameter.stationName = stationName;
    }

    public static String getWebserviceId() {
        return webserviceId;
    }
    public static void setWebserviceId(String webserviceId) {
        SysParameter.webserviceId = webserviceId;
    }
    public static String getWebservicePasswd() {
        return webservicePasswd;
    }
    public static void setWebservicePasswd(String webservicePasswd) {
        SysParameter.webservicePasswd = webservicePasswd;
    }


}