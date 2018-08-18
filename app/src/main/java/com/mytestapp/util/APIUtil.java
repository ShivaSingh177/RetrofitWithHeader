package com.mytestapp.util;

public class APIUtil {

    public APIUtil() {
    }
    public static final String BASE_URL = "http://api.schoolpnt.com/api/Api/";

    public static ConfigURLs appConfig(){
        return AppConfig.getClient(BASE_URL).create(ConfigURLs.class);
    }
}
