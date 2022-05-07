package com.thoughtworks.spotify;

public class UserDouble extends User {
    public boolean isShowSharedPlaylistsCalled = false;

    public UserDouble(int userId){
        super(userId);
    }
    @Override
    public void showSharedPlaylists() {
        isShowSharedPlaylistsCalled = true;
    }
}
