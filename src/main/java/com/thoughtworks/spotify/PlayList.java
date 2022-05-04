package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.SongAlreadyPresentInThePlaylistException;
import com.thoughtworks.exceptions.SongIsNotPresentInThePlaylistException;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> songsList;
    private boolean isShared;

    public PlayList(){
        songsList = new ArrayList<>();
        isShared = false;
    }

    public void addSong(Song song) throws SongAlreadyPresentInThePlaylistException {
        if(songsList.contains(song)) throw new SongAlreadyPresentInThePlaylistException();
        songsList.add(song);
    }

    public int songsCount() {
        return songsList.size();
    }

    public void removeSong(Song song) throws SongIsNotPresentInThePlaylistException {
        if(!songsList.contains(song)) throw new SongIsNotPresentInThePlaylistException();
        songsList.remove(song);
    }

    public void share() {
        isShared = true;
    }

    public boolean isShared() {
        return isShared;
    }
}
