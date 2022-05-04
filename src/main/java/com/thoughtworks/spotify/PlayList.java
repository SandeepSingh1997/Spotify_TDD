package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.SongAlreadyPresentInThePlayListException;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> songsList;

    public PlayList(){
        songsList = new ArrayList<>();
    }

    public void addSong(Song song) throws SongAlreadyPresentInThePlayListException{
        if(songsList.contains(song)) throw new SongAlreadyPresentInThePlayListException();
        songsList.add(song);
    }

    public int songsCount() {
        return songsList.size();
    }
}
