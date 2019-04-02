package com.lysoft.loginmvvmtemplete.di.module;

import android.content.Context;

import com.lysoft.loginmvvmtemplete.data.dataManager.DataManager;
import com.lysoft.loginmvvmtemplete.ui.login.LoginViewModel;
import com.lysoft.loginmvvmtemplete.utils.CustomLoading;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel loginViewModel(DataManager dataManager) {
        return new LoginViewModel(dataManager);
    }




}
