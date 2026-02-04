package com.easylive.entity.constants;

public class Constants {
    public static final Integer DEFAULT_PID = 0;
    public static final Integer DEFAULT_THEME = 1;
    public static final Integer REDIS_KEY_EXPIRES_ONE_MIN = 60000;
    public static final Integer REDIS_KEY_EXPIRES_ONE_DAY = REDIS_KEY_EXPIRES_ONE_MIN * 24 * 60;
    public static Integer length_10 = 10;
    public static Integer length_30 = 30;
    public static Integer DEFAULT_COIN_COUNT = 10;
    public static final String REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,20}$";


    public static final String FILE_FOLDER = "file/";
    public static final String FILE_COVER = "cover/";
    public static final String FILE_VIDEO = "video/";
    public static final String FILE_FOLDER_TEMP = "temp/";
    public static final String IMAGE_THUMBNAIL_SUFFIX = "_thumbnail.jpg";



    // redis
    public static final String REDIS_KEY_PREFIX = "easylive:";
    public static String REDIS_KEY_CHECK_CODE = REDIS_KEY_PREFIX + "checkCode:";
    public static String REDIS_KEY_TOKEN_WEB = REDIS_KEY_PREFIX + "token:web:";
    public static String REDIS_KEY_TOKEN_ADMIN = REDIS_KEY_PREFIX + "token:admin:";
    public static final String TOKEN_WEB = "token";
    public static final String TOKEN_ADMIN = "token-admin";
    public static final String REDIS_KEY_CATEGORY_LIST = REDIS_KEY_PREFIX + "category:list:";

}
