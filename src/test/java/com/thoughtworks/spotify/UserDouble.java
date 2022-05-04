package com.thoughtworks.spotify;

public class UserDouble extends User {
    public boolean isShowSharedPlaylistsCalled = false;

    @Override
    public void showSharedPlaylists() {
        isShowSharedPlaylistsCalled = true;
    }
}
