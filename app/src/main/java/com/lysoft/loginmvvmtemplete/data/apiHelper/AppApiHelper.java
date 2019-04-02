package com.lysoft.loginmvvmtemplete.data.apiHelper;

import android.content.Context;

import com.google.gson.Gson;
import com.lysoft.loginmvvmtemplete.data.dataManager.SharedPrefDataManager;
import com.lysoft.loginmvvmtemplete.data.model.remote.LoginResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppApiHelper implements ApiManager {

    @Inject
    public AppApiHelper() {}


    @Override
    public Single<LoginResponse> loginUser(String email, String password) {
        return Rx2AndroidNetworking.post(ApiEndPoints.LOGIN_ENDPOINT)
                .addHeaders("Content-Type", "application/json")
                .addBodyParameter("UserName", email)
                .addBodyParameter("Password", password)
                .build()
                .getObjectSingle(LoginResponse.class);
    }
}
