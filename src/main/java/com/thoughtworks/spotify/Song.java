package com.thoughtworks.spotify;

public class Song implements Cloneable{
    private int id;

    public Song(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    protected Song clone() throws CloneNotSupportedException {
        return new Song(this.id);
    }
}
