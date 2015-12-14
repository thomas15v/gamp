package com.resonanthost.gamp.gamewrapper.server;

import java.util.Map;

public class LaunchOptions {

    private String commandLine;

    public LaunchOptions(String commandLine, Map<String, String> args){
        for (String key : args.keySet()){
            commandLine = commandLine.replaceAll("\\{" + key + "\\}", args.get(key));
        }
        this.commandLine = commandLine;
    }

    public String getCommandLine() {
        return commandLine;
    }
}
