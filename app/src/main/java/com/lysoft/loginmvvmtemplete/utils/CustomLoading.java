package com.lysoft.loginmvvmtemplete.utils;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lysoft.loginmvvmtemplete.R;
import com.lysoft.loginmvvmtemplete.di.qualifier.PerActivity;

import javax.inject.Inject;

public class CustomLoading {
    private  Dialog dialog;


    ObjectAnimator animation;
    ImageView imageView;

    private static CustomLoading customLoading;
    private CustomLoading(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.custom_loading_dialog, null);
        dialog = new Dialog(context, R.style.FullHeightDialog);
        dialog.setContentView(dialogView);
        dialog.setCancelable(true);
        imageView = dialog.findViewById(R.id.imageView);
        LinearLayout loaders = dialogView.findViewById(R.id.loaders);
        animateRotation();
    }

    public static CustomLoading getCustomLoading (Context context) {
        if(customLoading == null){
            customLoading = new CustomLoading(context);
        }
        return customLoading;
    }

    private void animateRotation() {
        animation = ObjectAnimator.ofFloat(imageView, "rotationY", 0.0f, 360f);
        animation.setDuration(5000);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();
    }

    public void showDialog() {
        if (dialog != null && !dialog.isShowing())
            dialog.show();
    }

    public void dismissDialog() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

}
