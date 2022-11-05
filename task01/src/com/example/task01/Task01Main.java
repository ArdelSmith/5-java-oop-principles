package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger l1 = Logger.getLogger("test");
        Logger l2 = Logger.getLogger("test");
        l2.setName("345");
        l2.setLevel(Logger.Level.WARNING);
        l2.debug("123");
        l2.info("123");
        l2.warning("bebra occured");
        l2.error("123");

    }
}
