package com.edti.Interfaces;

import java.io.IOException;

public interface IGlobalSerialize<T> {
    void serialize(T object) throws IOException;
}
