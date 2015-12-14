package com.resonanthost.gamp.gamewrapper.user;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private File folder;

    public UserManager(File folder){
        this.folder = folder;
    }

    private Map<Integer, User> userMap = new HashMap<>();

    public User getOrCreateUser(int userid){
        if (userMap.containsKey(userid)){
            return userMap.get(userid);
        }
        else {
            User user = new User("user" + userid, folder);
            userMap.put(userid, user);
            return user;
        }
    }
}
