package com.lysoft.loginmvvmtemplete.di.component;

import android.app.Application;

import com.lysoft.loginmvvmtemplete.BaseApp;
import com.lysoft.loginmvvmtemplete.di.builder.ActivityBuilder;
import com.lysoft.loginmvvmtemplete.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(BaseApp baseApp);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
