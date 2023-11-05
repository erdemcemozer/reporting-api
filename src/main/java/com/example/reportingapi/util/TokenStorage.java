package com.example.reportingapi.util;

/**
 * @Author Erdem Ozer
 * Date: 04/11/2023
 */

// Singleton token storage for users token
public class TokenStorage {
    private static TokenStorage instance;
    private String token;

    public TokenStorage() {
    }

    public static TokenStorage getInstance() {
        if (instance == null) {
            synchronized (TokenStorage.class) {
                if (instance == null) {
                    instance = new TokenStorage();
                }
            }
        }
        return instance;
    }

    public void setToken(String newToken) {
        this.token = newToken;
    }

    public String getToken() {
        return this.token;
    }
}
