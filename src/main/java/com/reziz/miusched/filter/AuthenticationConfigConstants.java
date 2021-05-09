package com.reziz.miusched.filter;

public class AuthenticationConfigConstants {
    public static final String SECRET = "ree_secret";
    public static final long EXPIRATION_TIME = 3600000; // 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/user";
}
