package com.nashtech.demoqa.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtil {
    public static JsonReader loadJsonfile (String nameOfJsonTestData) throws FileNotFoundException {
        String filepath = System.getProperty("DATA_PATH") + nameOfJsonTestData;
        JsonReader reader = new JsonReader(new FileReader(filepath));
        return reader;
    }

    public static void writeJsonfile(String nameOfJsonTestData) throws IOException {
        String filepath = System.getProperty("DATA_PATH") + nameOfJsonTestData;
        JsonWriter writer = new JsonWriter(new FileWriter(filepath));
    }
    public static <T> T convertToJsonObject (String nameJsonFile, Class<T> kclass) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.loadJsonfile(nameJsonFile);
        Gson gson = new Gson();
        T object = gson.fromJson(reader, kclass);
        return object;
    }
}
