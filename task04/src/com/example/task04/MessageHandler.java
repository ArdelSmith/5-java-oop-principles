package com.example.task04;

import java.util.Objects;

@FunctionalInterface
public interface MessageHandler {
    void Log(String message);
}
