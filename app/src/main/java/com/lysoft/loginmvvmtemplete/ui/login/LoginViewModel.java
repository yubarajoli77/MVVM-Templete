package com.lysoft.loginmvvmtemplete.ui.login;

import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.lysoft.loginmvvmtemplete.data.dataManager.DataManager;
import com.lysoft.loginmvvmtemplete.data.model.remote.LoginResponse;
import com.lysoft.loginmvvmtemplete.ui.base.BaseViewModel;
import com.lysoft.loginmvvmtemplete.utils.AppConstants;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {


    public LoginViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void onForgotPasswordClicked() {
        getNavigator().startForgotPasswordActivity();
    }

    public void onCreateNewAccountClicked() {
        getNavigator().startRegisterActivity();
    }

    public void onLoginClicked() {
        getNavigator().login();
    }

    public void onSkipClicked(){
        getNavigator().onSkipedClicked();
    }

    public void login(String email, String password) {
        //This is only for testing
        getNavigator().onLoginSuccessful(email);

        //Actual implementation look like this one

//        getCompositeDisposable().add(getDataManager()
//                .loginUser(email, password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(loginResponse -> {
//                    /*
//                    Do some logic with the loginResponse
//                    But We have to first look on the LoginResponse Class and make sure that
//                    we created it according to server response
//                    */
//
//                }, failure -> {
//                    /*
//                    Set Error with the help of failure object. We can do our own logic like map error
//                    and call a particular interface method.
//                     */
//                }));
    }

}
