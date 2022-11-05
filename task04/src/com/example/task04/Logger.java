package com.example.task04;

import java.util.*;
import java.text.*;
import java.util.HashMap;

public class Logger {

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR,
    }
    private static HashMap<String, Logger> dictionary = new HashMap<>();
    private Level level;
    private String name;
    private List<MessageHandler> interfaces = new ArrayList<MessageHandler>();
    public Logger(String str){
        this.name = str;
    }
    public Logger(String string, MessageHandler... interfaces){
        this.name = string;
        this.interfaces.addAll(Arrays.asList(interfaces));
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public Level getLevel(){
        return this.level;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public static Logger getLogger(String name){
        if (dictionary.get(name) == null) {
            dictionary.put(name, new Logger(name));
            dictionary.get(name).setLevel(Level.DEBUG);
            return dictionary.get(name);
        }
        else return dictionary.get(name);
    }
    public void debug(String message){
        log(Level.DEBUG, message);
    }
    public void debug(String format, Object... params){
        log(Level.DEBUG, format, params);
    }
    public void info(String message){
        log(Level.INFO, message);
    }
    public void info(String format, Object... params){
        log(Level.INFO, format, params);
    }
    public void warning(String message){
        log(Level.WARNING, message);
    }
    public void warning(String format, Object... params){
        log(Level.WARNING, format, params);
    }
    public void error(String message){
        log(Level.ERROR, message);
    }
    public void error(String format, Object... params){
        log(Level.ERROR, format, params);
    }

    public void log(Level level, String message) {
        if (this.level.ordinal() <= level.ordinal()){
            String temp = String.format("[%s] %s %s %s - %s", level, new SimpleDateFormat("yyyy.MM.dd").format(new Date()),
                    new SimpleDateFormat("hh:mm:ss").format(new Date()),
                    this.name, message);
            for (MessageHandler msg: interfaces){
                msg.Log(temp);
            }
        }
    }
    public void log(Level level, String format, Object... params) {
        if (this.level.ordinal() <= level.ordinal()){
            String temp = String.format(format, params);
            for (MessageHandler msg: interfaces){
                msg.Log(temp);
            }
        }
    }


}
