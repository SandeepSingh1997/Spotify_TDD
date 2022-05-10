package com.thoughtworks.spotify;

import java.lang.management.PlatformManagedObject;
import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    private List<PlayList> playLists;

    public User(int userId){
        this.userId = userId;
        playLists = new ArrayList<>();
    }

    public void addPlaylist(PlayList playList) {
        playLists.add(playList);
    }

    public int playListsSize() {
        return playLists.size();
    }

    public int sharedPlayListsCount() {
        int sharedPlaylistsCount = 0;
        for(PlayList playList : playLists){
            if(playList.isShared()){
                sharedPlaylistsCount++;
            }
        }
        return sharedPlaylistsCount;
    }

    public List<PlayList> getSharedPlaylists() throws CloneNotSupportedException {
        List<PlayList> sharedPlaylists = new ArrayList<>();
        for(PlayList playList : playLists){
            if(playList.isShared())
            { sharedPlaylists.add(playList.clone());
            }
        }
        return sharedPlaylists;
    }

    public void sharePlaylistTo(PlayList playList, User user2) {
        user2.addPlaylist(playList);
    }
}

