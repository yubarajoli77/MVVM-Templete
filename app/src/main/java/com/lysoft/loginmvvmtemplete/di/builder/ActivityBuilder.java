package com.lysoft.loginmvvmtemplete.di.builder;

import com.lysoft.loginmvvmtemplete.di.module.LoginActivityModule;
import com.lysoft.loginmvvmtemplete.ui.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {LoginActivityModule.class})
    abstract LoginActivity bindLoginActivity();

}
