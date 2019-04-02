package com.lysoft.loginmvvmtemplete.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.lysoft.loginmvvmtemplete.R;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CustomSnackBar {

    private Context mContext;
    private Snackbar snackbar;

    public CustomSnackBar(Context mContext) {
        this.mContext = mContext;
    }

    public Snackbar showError(String message, int type, View parent) {
        snackbar = Snackbar.make(parent, message, type);
        snackbar.getView().setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        return snackbar;
    }
}
