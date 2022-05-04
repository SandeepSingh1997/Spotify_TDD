package com.thoughtworks.spotify;

public class SpotifyManagerDouble extends SpotifyManager{
    public boolean isShowOpenPlaylistsCalled = false;
    @Override
    public void showOpenPlaylists() {
        isShowOpenPlaylistsCalled = true;
    }
}
