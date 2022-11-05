package com.example.task04;
import java.io.*;

public class FileHandler implements MessageHandler{
    private final String fileName;
    private PrintWriter pW;
    public FileHandler(String fileName){
        this.fileName = fileName;
        try{
            pW = new PrintWriter(fileName + ".txt");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void Log(String message){
        pW.println(message);
        pW.flush();
        System.out.println("The file has been written");
    }
}
