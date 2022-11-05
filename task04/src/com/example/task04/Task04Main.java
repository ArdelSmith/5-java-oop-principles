package com.example.task04;

import java.util.ArrayList;

public class Task04Main {
    public static void main(String[] args) {
    Logger bebra = new Logger("123", new ConsoleHandler(), new FileHandler("bebra"));
    bebra.setLevel(Logger.Level.DEBUG);
    bebra.debug("123");
    bebra.error("122");
    }
}
