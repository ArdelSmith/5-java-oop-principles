package com.example.task04;
import java.time.LocalDateTime;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{

    private final String fileName;
    private final ChronoUnit chronoUnit;
    public RotationFileHandler(String fileName, ChronoUnit chronoUnit){
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void Log(String message){
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime time = nowTime.truncatedTo(chronoUnit);
        try {
            FileWriter _fileWriter = new FileWriter(fileName + "" +
                    time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss")) + ".txt", true);

            _fileWriter.write(message);

            _fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
