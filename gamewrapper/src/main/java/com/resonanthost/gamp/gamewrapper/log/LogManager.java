package com.resonanthost.gamp.gamewrapper.log;

import org.apache.commons.exec.LogOutputStream;

import java.util.ArrayList;
import java.util.List;

public class LogManager extends LogOutputStream {

    private int max;
    private List<String> logs = new ArrayList<String>();

    public LogManager(int max){
        this.max = max;
    }

    @Override
    public void processLine(String line, int logLevel) {
        logs.add(line);
        if (logs.size() > max){
            logs.remove(logs.size() - 1);
        }
        System.out.println(line);
    }

}
