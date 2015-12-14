package com.resonanthost.gamp.gamewrapper.server;

import com.resonanthost.gamp.gamewrapper.user.User;
import com.resonanthost.gamp.gamewrapper.log.LogManager;
import org.apache.commons.exec.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class GameServer {

    private final File folder;
    private User user;
    private LaunchOptions serverOptions;
    private final DefaultExecutor executor = new DefaultExecutor();
    private final LogManager logManager;

    public GameServer(User user, final int id, LaunchOptions serverOptions){
        this.user = user;
        this.serverOptions = serverOptions;
        this.folder = new File(user.getFolder(), "server" + id);
        this.folder.mkdirs();
        this.executor.setWorkingDirectory(folder);
        this.logManager = new LogManager(100);
        this.executor.setStreamHandler(new PumpStreamHandler(logManager));
    }

    public void start(){
        try {
            executor.execute(CommandLine.parse(serverOptions.getCommandLine()));
        } catch (ExecuteException e) {
            logManager.processLine(e.getMessage(), Level.SEVERE.intValue() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
