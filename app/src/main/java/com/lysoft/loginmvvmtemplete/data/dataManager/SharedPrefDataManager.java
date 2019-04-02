package com.lysoft.loginmvvmtemplete.data.dataManager;

public interface SharedPrefDataManager {

    void setToken(String token);
    String getToken();

    void setName(String name);
    String getName();

    void setEmail(String email);
    String getEmail();

    void setPhone(String phone);
    String getPhone();
}
