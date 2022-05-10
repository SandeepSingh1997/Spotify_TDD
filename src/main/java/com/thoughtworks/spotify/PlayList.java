package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.InvalidRatingException;
import com.thoughtworks.exceptions.SongAlreadyPresentInThePlaylistException;
import com.thoughtworks.exceptions.SongIsNotPresentInThePlaylistException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Stream<Song> songsStream = songsList.stream();
        List<Song> clonedList = songsStream.map(song -> {
            try {
                return song.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }).collect(Collectors.toList());
        return clonedList;
    }

    public PlayList getShuffledPlaylist() throws CloneNotSupportedException {
        PlayList shuffledPlaylist = this.clone();
        Collections.shuffle(shuffledPlaylist.songsList);
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
