package com.resonanthost.gamp.gamewrapper;

import com.resonanthost.gamp.gamewrapper.server.GameServer;
import com.resonanthost.gamp.gamewrapper.server.LaunchOptions;
import com.resonanthost.gamp.gamewrapper.user.User;
import com.resonanthost.gamp.gamewrapper.user.UserManager;

import java.io.File;
import java.util.HashMap;

public class Manager {

    public static void main(String[] args){
        File serverfolder = new File("./servers");
        serverfolder.mkdirs();
        UserManager userManager = new UserManager(serverfolder);
        User user = userManager.getOrCreateUser(1);
        LaunchOptions launchOptions = new LaunchOptions("java -jar {jarName}", new HashMap<String, String>(){
            {
                put("jarName", "minecraft_server.1.8.8.jar");
            }
        });
        GameServer server = new GameServer(user, 1,launchOptions);
        server.start();


    }

}
