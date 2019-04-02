package com.lysoft.loginmvvmtemplete.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lysoft.loginmvvmtemplete.data.apiHelper.ApiManager;
import com.lysoft.loginmvvmtemplete.data.apiHelper.AppApiHelper;
import com.lysoft.loginmvvmtemplete.data.dataManager.AppDataHelper;
import com.lysoft.loginmvvmtemplete.data.dataManager.DataManager;
import com.lysoft.loginmvvmtemplete.di.qualifier.ApplicationContext;
import com.lysoft.loginmvvmtemplete.di.qualifier.PerActivity;
import com.lysoft.loginmvvmtemplete.utils.CustomLoading;
import com.lysoft.loginmvvmtemplete.utils.CustomSnackBar;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiManager provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataHelper appDataHelper){
        return appDataHelper;
    }

    @Provides
    CustomSnackBar provideCustomSnackBar(Context mContext){
        return new CustomSnackBar(mContext);
    }

}
