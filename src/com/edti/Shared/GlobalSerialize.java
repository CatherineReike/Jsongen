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

    private final Path PATH = Paths.get("Files/teszt.json");

    @Override
    public void serialize(T object) throws IOException {
        setGsonObject();
        String objectString = gson.toJson(object);

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
