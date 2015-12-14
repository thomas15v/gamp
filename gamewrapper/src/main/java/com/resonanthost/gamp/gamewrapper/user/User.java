package com.resonanthost.gamp.gamewrapper.user;

import java.io.File;

public class User {

    private String name;
    private File folder;

    User(String name, File folder){
        this.name = name;
        this.folder = new File(folder, name);
        this.folder.mkdirs();
    }

    public String getName() {
        return name;
    }

    public File getFolder() {
        return folder;
    }
}
