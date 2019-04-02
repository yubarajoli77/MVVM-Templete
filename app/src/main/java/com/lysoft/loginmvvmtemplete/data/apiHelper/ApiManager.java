package com.lysoft.loginmvvmtemplete.data.apiHelper;

import com.lysoft.loginmvvmtemplete.data.model.remote.LoginResponse;

import io.reactivex.Single;


public interface ApiManager {

    Single<LoginResponse> loginUser(String email, String password);

}
