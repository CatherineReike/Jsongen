package com.edti.Shared;

import com.edti.Interfaces.IGlobalSerialize;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class GlobalSerialize<T> implements IGlobalSerialize<T> {
    private Gson gson = new Gson();
    private Path PATH;

    private void getPath(String name){
        PATH = Paths.get(String.format("/Users/vasvince/Documents/Munka/Jsongen/Files/%s.json", name));
    }


    @Override
    public void serialize(T object, String pathName) throws IOException {
        getPath(pathName);
        setGsonObject();
        String objectString = gson.toJson(object);

        System.out.println(PATH);
        if (!Files.exists(PATH)) {
            Files.createFile(PATH);
        }
        Files.writeString(PATH, objectString);
    }

    private void setGsonObject() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gson = builder.create();
    }

}
