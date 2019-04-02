package com.lysoft.loginmvvmtemplete.ui.login;

import android.animation.Animator;
import android.app.Activity;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.lysoft.loginmvvmtemplete.BR;
import com.lysoft.loginmvvmtemplete.R;
import com.lysoft.loginmvvmtemplete.databinding.ActivityLoginBinding;
import com.lysoft.loginmvvmtemplete.ui.base.BaseActivity;
import com.lysoft.loginmvvmtemplete.ui.base.BaseViewModel;
import com.lysoft.loginmvvmtemplete.utils.CustomLoading;
import com.lysoft.loginmvvmtemplete.utils.CustomSnackBar;
import com.lysoft.loginmvvmtemplete.utils.NetworkUtils;

import java.util.Objects;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> implements LoginNavigator{



    @Inject
    public LoginViewModel mLoginViewModel;

    @Inject
    public CustomSnackBar customSnackBar;

    private ActivityLoginBinding mLoginActivity;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.loginViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);



        mLoginActivity = getViewBinding();

        mLoginViewModel.setNavigator(this);



        new CountDownTimer(5000, 2000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mLoginActivity.bookITextView.setVisibility(GONE);
                mLoginActivity.loadingProgressBar.setVisibility(GONE);
                mLoginActivity.rootView.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.colorSplashText));
                mLoginActivity.bookIconImageView.setImageResource(R.drawable.background_color_book);
                startAnimation();
            }
        }.start();

        setUpListeners();
    }


    private void setUpListeners() {
        mLoginActivity.loginButton.setOnClickListener(v -> {
            if(isFinishing())
                return;

            customLoading.showDialog();
            mLoginViewModel.onLoginClicked();
        });

        mLoginActivity.tvForgetPsw.setOnClickListener(view-> mLoginViewModel.onForgotPasswordClicked());

        mLoginActivity.tvRegister.setOnClickListener(view-> mLoginViewModel.onCreateNewAccountClicked());

        mLoginActivity.skipTextView.setOnClickListener(view-> mLoginViewModel.onSkipClicked());
    }


    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator= mLoginActivity.bookIconImageView.animate();
        viewPropertyAnimator.x(50f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginActivity.afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public void startForgotPasswordActivity() {
        //Your forget password logic here
//        Toast.makeText(this, "Forget Password Clicked", Toast.LENGTH_SHORT).show();
        customSnackBar.showError("Forget Password Clicked", Snackbar.LENGTH_SHORT,mLoginActivity.rootView).show();
    }

    @Override
    public void startRegisterActivity() {
        //Your register logic here
        Toast.makeText(this, "Register User  Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSkipedClicked() {
        //Your skip logic here
        Toast.makeText(this, "Skip Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        String email = Objects.requireNonNull(mLoginActivity.emailEditText.getText()).toString().trim();
        String password = Objects.requireNonNull(mLoginActivity.passwordEditText.getText()).toString().trim();

        if (!TextUtils.isEmpty(mLoginActivity.emailEditText.getText()) && !TextUtils.isEmpty(mLoginActivity.passwordEditText.getText())) {
            if (NetworkUtils.isNetworkConnected(this))
                mLoginViewModel.login(email, password);
            else {
                Toast.makeText(this,getResources().getString(R.string.no_internet_connection) , Toast.LENGTH_SHORT).show();
//                showMessageDialog(getResources().getString(R.string.no_internet_connection),
//                        getResources().getString(R.string.retry_connection),
//                        getResources().getString(R.string.cancel), false);

            }
        }
    }

    @Override
    public void startMainActivity() {
        // StartMainActivity is just here to start any activity we like after successful login
    }

    @Override
    public void onLoginSuccessful(String email) {
        Toast.makeText(this, "Howdy "+email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNetworkIssue() {
        //Your error logic here
    }

    @Override
    public void onUnKnownFailure() {
        //Your unknown error which is just here for the error type that are unknown

    }
}
