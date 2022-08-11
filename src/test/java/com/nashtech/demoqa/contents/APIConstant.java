package com.nashtech.demoqa.contents;

public class APIConstant {
    public enum RequestType {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH
    }

    public static String DEMOQA_HOST = "https://demoqa.com";
    public static String[] PUBLIC_BOOK_ID = {"9781449325862", "9781449331818"};
    public static String NEW_BOOK_ID = "9781593277574";
    public static String DEMOQA_ACCOUNT_PREFIX = "/Account/v1";
    public static String LOGIN_ENDPOINT = "/Authorized";
    public static String GENERATE_TOKEN_ENDPOINT = "/GenerateToken";
    public static String CREATE_USER_ENDPOINT = "/User";
    public static String GET_DETAIL_USER_ENDPOINT = "/User/%s";
    public static String DEMOQA_BOOK_STORE_PREFIX = "/BookStore/v1";
    public static String GET_DETAIL_ALL_BOOK_ENDPOINT = "/Books";
    public static String GET_DETAIL_BOOK_ENDPOINT = "/Book?ISBN=%s";
    public static String REPLACE_BOOK_ENDPOINT = "/Books/%s";
    public static String ADD_BOOK_TO_COLLECTION_ENDPOINT = "/Books";
    public static String DELETE_BOOK_IN_COLLECTION_ENDPOINT = "/Book";
    public static String DELETE_ALL_BOOKS_IN_COLLECTION_ENDPOINT = "/Books?UserId=%s";
}
