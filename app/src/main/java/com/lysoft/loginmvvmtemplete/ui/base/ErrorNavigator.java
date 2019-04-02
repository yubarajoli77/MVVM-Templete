package com.lysoft.loginmvvmtemplete.ui.base;

public interface ErrorNavigator {
    void onNetworkIssue();

    void onUnKnownFailure();

    //We can add here a common types of error that may be occurred during api call.
}
