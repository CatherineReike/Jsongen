package com.edti.Interfaces;

import java.io.IOException;

public interface IGlobalSerialize<T> {
    void serialize(T object,  String pathName) throws IOException;
}
