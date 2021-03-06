package org.bsu.famcs.bookstoremobappserver.config;

public class SecurityCredentials {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";


    public static final String SIGN_UP_URL = "/sign-up";
    public static final String CATALOG_URL = "/catalog/books";
    public static final String SWAGGER_URL = "/swagger-ui/#/";
}
