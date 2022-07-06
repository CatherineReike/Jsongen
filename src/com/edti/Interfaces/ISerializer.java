package com.edti.Interfaces;

import java.io.IOException;

public interface ISerializer<T> {
    void Serializer(T object) throws IOException;
}
