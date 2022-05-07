package com.thoughtworks.spotify;

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

    public void showSharedPlaylists() {
        for(PlayList playList : playLists){
            if(playList.isShared())
            { System.out.println(playList);
            }
        }
    }
}

