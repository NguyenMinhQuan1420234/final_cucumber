package com.nashtech.demoqa.utils.api.contents;

import com.nashtech.demoqa.contents.APIConstant;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BookstoreHelper extends RequestHelper{
    private String prefixUrl = APIConstant.DEMOQA_HOST + APIConstant.DEMOQA_BOOK_STORE_PREFIX;


//    public BookstoreHelper() throws FileNotFoundException {
//        Gson gson = new Gson();
//        JsonReader reader = JsonUtil.loadJsonfile("RegisterStudentTestData.json");
//        RegisterStudentData registerStudentData = gson.fromJson(reader, RegisterStudentData.class);
//    }

    public Response getAllBookInfo(String isbn) {
        String url = prefixUrl + String.format(APIConstant.GET_DETAIL_ALL_BOOK_ENDPOINT, isbn);
        Response response = sendRequest(
                APIConstant.RequestType.GET,
                url,
                null,
                toString());
        return response;
    }
    public Response getOneBookInfo(String isbn) {
        String url = prefixUrl + String.format(APIConstant.GET_DETAIL_BOOK_ENDPOINT, isbn);
        Response response = sendRequest(
                APIConstant.RequestType.GET,
                url,
                null,
                toString());
        return response;
    }

    public Response addNewBooks(String userToken, String userId, String[] isbn) {
        String url = prefixUrl + APIConstant.ADD_BOOK_TO_COLLECTION_ENDPOINT;
        JSONObject body = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = createHeaders(map);
        JSONArray collectionIsbns = new JSONArray();
        for (String id: isbn) {
            JSONObject bookId = new JSONObject();
            bookId.put("isbn", id);
            collectionIsbns.add(bookId);
        }
        body.put("userId", userId);
        body.put("collectionOfIsbns", collectionIsbns);
        Response response = sendRequest(
                APIConstant.RequestType.POST,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response addNewBooks(String userToken, String userId, String isbn) {
        String url = prefixUrl + APIConstant.ADD_BOOK_TO_COLLECTION_ENDPOINT;
        JSONObject body = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = createHeaders(map);
        JSONArray collectionIsbns = new JSONArray();
        JSONObject bookId = new JSONObject();
        bookId.put("isbn", isbn);
        collectionIsbns.add(bookId);
        body.put("userId", userId);
        body.put("collectionOfIsbns", collectionIsbns);
        Response response = sendRequest(
                APIConstant.RequestType.POST,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response deleteAllBooks(String userToken, String userId) {
        String url = prefixUrl + String.format(APIConstant.DELETE_ALL_BOOKS_IN_COLLECTION_ENDPOINT, userId);
        Map<String,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = createHeaders(map);
        Response response = sendRequest(
                APIConstant.RequestType.DELETE,
                url,
                headers,
                "");
        return response;
    }

    public Response deleteBook(String userToken, String userId, String isbn) {
        String url = prefixUrl + APIConstant.DELETE_BOOK_IN_COLLECTION_ENDPOINT;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = createHeaders(map);
        JSONObject body = new JSONObject();
        body.put("isbn", isbn);
        body.put("userId", userId);
        Response response = sendRequest(
                APIConstant.RequestType.DELETE,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response replaceBook(String userToken, String userId, String currentIsbn, String newIsbn) {
        String url = prefixUrl + String.format(APIConstant.REPLACE_BOOK_ENDPOINT, currentIsbn);
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = createHeaders(map);
        JSONObject body = new JSONObject();
        body.put("isbn", newIsbn);
        body.put("userId", userId);
        Response response = sendRequest(
                APIConstant.RequestType.PUT,
                url,
                headers,
                body.toString());
        return response;
    }
}
