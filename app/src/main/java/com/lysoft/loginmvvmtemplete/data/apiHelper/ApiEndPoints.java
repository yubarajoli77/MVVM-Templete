package com.lysoft.loginmvvmtemplete.data.apiHelper;

import com.lysoft.loginmvvmtemplete.utils.AppConstants;

public final class ApiEndPoints {
    private static String BASE_URL = AppConstants.Server.BASE_URL;

    /*
    In case if we have mid_url then
    BASE_URL = AppConstants.Server.BASE_URL + MID_URL;

    And for photo if base url is same
        PHOTO_URL = AppConstants.Server.BASE_URL + PHOTO_URL;
    * */

    public static final String LOGIN_ENDPOINT = BASE_URL + "/login";

}
