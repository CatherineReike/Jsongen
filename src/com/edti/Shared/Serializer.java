package com.edti.Shared;

import com.edti.Interfaces.ISerializer;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serializer<T> implements ISerializer<T> {
    private Gson gson;

    private final Path PATH = Paths.get("Files/teszt.json");


    @Override
    public void Serializer(T object) throws IOException {
        String objectString = this.gson.toJson(object);

        if (!Files.exists(PATH)) {
            Files.createFile(PATH);
        }
        Files.writeString(PATH, objectString);
    }
}
