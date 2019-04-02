package com.lysoft.loginmvvmtemplete.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.lysoft.loginmvvmtemplete.data.dataManager.DataManager;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {

    /*
    This viewmodel class is used for common data manipulation like:
    LogOut may be the common function which is happened from anywhere
    User status check like Blocked, Active, Deleted at app is in memory
    Token expiry test and many more
     */


    private final DataManager mDataManager;

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator;

    public BaseViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }


    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
