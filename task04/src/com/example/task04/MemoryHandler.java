package com.example.task04;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final List<MessageHandler> messageHandlers = new ArrayList<>();
    private final List<String> buffer = new ArrayList<>();
    private final int bS;


    public MemoryHandler(int bufferSize, MessageHandler... handlers) {
        this.bS = bufferSize;
        messageHandlers.addAll(Arrays.asList(handlers));
    }

    @Override
    public void Log(String message) {
        buffer.add(message);
        if (buffer.size() == bS) {
            logBuffer();
        }

    }

    public void logBuffer() {
        for (MessageHandler handler : messageHandlers) {
            for (String msg : buffer) {
                handler.Log(msg);
            }
        }
        buffer.clear();
    }
}
