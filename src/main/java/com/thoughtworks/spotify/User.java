package com.thoughtworks.spotify;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<PlayList> playLists;

    public User(){
        playLists = new ArrayList<>();
    }

    public void createPlaylist(PlayList playList) {
        playLists.add(playList);
    }

    public int playListsCount() {
        return playLists.size();
    }
}
