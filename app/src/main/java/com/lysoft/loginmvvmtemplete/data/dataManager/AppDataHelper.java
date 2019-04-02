package com.lysoft.loginmvvmtemplete.data.dataManager;

import android.content.Context;

import com.google.gson.Gson;
import com.lysoft.loginmvvmtemplete.data.apiHelper.ApiManager;
import com.lysoft.loginmvvmtemplete.data.model.remote.LoginResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppDataHelper implements DataManager {

    private final ApiManager apiManager;

    private final Context context;

    private final Gson gson;

    private final AppSharedPrefHelper appSharedPrefHelper;


    @Inject
    public AppDataHelper(Context context, AppSharedPrefHelper appSharedPrefHelper, ApiManager apiManager, Gson gson) {
        this.context = context;
        this.appSharedPrefHelper = appSharedPrefHelper;
        this.apiManager = apiManager;
        this.gson = gson;
    }

    @Override
    public Single<LoginResponse> loginUser(String email, String password) {
        return apiManager.loginUser(email,password);
    }

    @Override
    public void setToken(String token) {
        appSharedPrefHelper.setToken(token);
    }

    @Override
    public String getToken() {
        return appSharedPrefHelper.getToken();
    }

    @Override
    public void setName(String name) {
        appSharedPrefHelper.setName(name);
    }

    @Override
    public String getName() {
        return appSharedPrefHelper.getName();
    }

    @Override
    public void setEmail(String email) {
        appSharedPrefHelper.setEmail(email);
    }

    @Override
    public String getEmail() {
        return appSharedPrefHelper.getEmail();
    }

    @Override
    public void setPhone(String phone) {
        appSharedPrefHelper.setPhone(phone);
    }

    @Override
    public String getPhone() {
        return appSharedPrefHelper.getPhone();
    }
}
