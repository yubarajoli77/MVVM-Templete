package com.lysoft.loginmvvmtemplete.utils;

public final class AppConstants {
    public static final String SHARED_PREF_KEY = "SharedPrefKey";
    public static final String STRING_DEFAULT_VALUE = "N/A";
    public static final int INTEGER_DEFAULT_VALUE = 0;

    public static final class SharePrefConstants{
        public static final String LOGIN_TOKEN_KEY = "LoginToken";
        public static final String USER_NAME = "UserName";
        public static final String USER_EMAIL = "UserEmail";
        public static final String USER_PHONE = "UserPhone";
    }

    public static final class Server{
        public static final String BASE_URL = "https://yourBaseUrl.com";

        //In case we have different mid url and photo url
        public static final String MID_URL = "/yourMidUrl";     //Optional
        public static final String PHOTO_URL = "/yourPhotoUrl"; //Optional

    }
}
