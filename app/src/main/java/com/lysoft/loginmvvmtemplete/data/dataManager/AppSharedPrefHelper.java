package com.lysoft.loginmvvmtemplete.data.dataManager;

import android.content.Context;
import android.content.SharedPreferences;

import com.lysoft.loginmvvmtemplete.utils.AppConstants;

import javax.inject.Inject;

public class AppSharedPrefHelper implements SharedPrefDataManager {

    private SharedPreferences sharedPreferences;

    @Inject
    AppSharedPrefHelper(Context mContext){
        sharedPreferences = mContext.getSharedPreferences(AppConstants.SHARED_PREF_KEY,Context.MODE_PRIVATE);
    }

    @Override
    public void setToken(String token) {
        sharedPreferences.edit().putString(AppConstants.SharePrefConstants.LOGIN_TOKEN_KEY,token).apply();
    }

    @Override
    public String getToken() {
        return sharedPreferences.getString(AppConstants.SharePrefConstants.LOGIN_TOKEN_KEY,AppConstants.STRING_DEFAULT_VALUE);
    }

    @Override
    public void setName(String name) {
        sharedPreferences.edit().putString(AppConstants.SharePrefConstants.USER_NAME,name).apply();

    }

    @Override
    public String getName() {
        return sharedPreferences.getString(AppConstants.SharePrefConstants.USER_NAME,AppConstants.STRING_DEFAULT_VALUE);
    }

    @Override
    public void setEmail(String email) {
        sharedPreferences.edit().putString(AppConstants.SharePrefConstants.USER_EMAIL,email).apply();

    }

    @Override
    public String getEmail() {
        return sharedPreferences.getString(AppConstants.SharePrefConstants.USER_EMAIL,AppConstants.STRING_DEFAULT_VALUE);
    }

    @Override
    public void setPhone(String phone) {
        sharedPreferences.edit().putString(AppConstants.SharePrefConstants.USER_PHONE,phone).apply();

    }

    @Override
    public String getPhone() {
        return sharedPreferences.getString(AppConstants.SharePrefConstants.USER_PHONE,AppConstants.STRING_DEFAULT_VALUE);
    }
}
