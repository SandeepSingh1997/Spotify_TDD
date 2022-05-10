package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.InvalidRatingException;
import com.thoughtworks.exceptions.SongAlreadyPresentInThePlaylistException;
import com.thoughtworks.exceptions.SongIsNotPresentInThePlaylistException;

import java.util.*;

public class PlayList implements Cloneable{
    private int id;
    private List<Song> songsList;
    private boolean isShared;
    private int rating;

    public PlayList(int id){
        this.id = id;
        songsList = new ArrayList<>();
        isShared = false;
    }

    public void addSong(Song song) throws SongAlreadyPresentInThePlaylistException {
        if(songsList.contains(song)) throw new SongAlreadyPresentInThePlaylistException();
        songsList.add(song);
    }

    public int size(){
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

    public void rate(int rating) throws InvalidRatingException {
        if(rating > 5 || rating < 1) throw new InvalidRatingException();
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public List<Song> getSongs() throws CloneNotSupportedException {
        List<Song> clonedList = new ArrayList<>();
        for(Song song : this.songsList){
            clonedList.add(song.clone());
        }
        return clonedList;
    }

    public PlayList getShuffledPlaylist() throws CloneNotSupportedException {
        PlayList shuffledPlaylist = this.clone();
        Random random = new Random();
        for(int i=0; i<shuffledPlaylist.songsList.size(); i++){
            int randInt = random.nextInt(shuffledPlaylist.songsList.size());
            Collections.swap(shuffledPlaylist.songsList,i, randInt);
        }
        return shuffledPlaylist;
    }

    @Override
    protected PlayList clone() throws CloneNotSupportedException {
        PlayList clonedPlaylist = new PlayList(id);
        clonedPlaylist.songsList = getSongs();
        return clonedPlaylist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return id == playList.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
