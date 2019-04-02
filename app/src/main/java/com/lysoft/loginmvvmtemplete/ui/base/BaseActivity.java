package com.lysoft.loginmvvmtemplete.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.lysoft.loginmvvmtemplete.utils.CustomLoading;

import dagger.android.AndroidInjection;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    public CustomLoading customLoading;
    private V mViewModel;
    private T mActivity;

    @LayoutRes
    public abstract int getLayoutId();

    public abstract V getViewModel();

    public abstract int getBindingVariable();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();
        customLoading = CustomLoading.getCustomLoading(this);
    }

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    private void performDataBinding() {
        mActivity = DataBindingUtil.setContentView(this,getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mActivity.setVariable(getBindingVariable(),mViewModel);
    }

    public T getViewBinding(){
        return mActivity;
    }


    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

}
