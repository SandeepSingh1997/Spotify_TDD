package com.thoughtworks.spotify;

import java.util.ArrayList;
import java.util.List;

public class SpotifyManager {
    private List<User> userList;

    public SpotifyManager(){
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public int userCount() {
        return userList.size();
    }

    public int countOpenPlaylists() {
        int openPlayListsCount = 0;
        for(User user : userList){
            openPlayListsCount += user.sharedPlayListsCount();
        }
        return openPlayListsCount;
    }

    public void showOpenPlaylists(){
        for(User user : userList){
            user.showSharedPlaylists();
        }
    }

}
