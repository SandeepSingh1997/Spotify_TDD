package com.thoughtworks.spotify;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpotifyManagerTest {
    @Test
    public void shouldBeAbleToAddUser(){
        SpotifyManager spotifyManager = new SpotifyManager();
        User user = new User();
        int expectedUsersCount = 1;

        spotifyManager.addUser(user);
        int actualUsersCount = spotifyManager.userCount();

        assertThat(actualUsersCount, is(expectedUsersCount));
    }

    @Test
    public void shouldReturnCountOfOpenPlaylistsAsTwoWhenTwoPlaylistsAreShared(){
        SpotifyManager spotifyManager = new SpotifyManager();
        User user1 = new User();
        User user2 = new User();
        PlayList playList1 = new PlayList();
        PlayList playList2 = new PlayList();
        PlayList playList3 = new PlayList();
        user1.createPlaylist(playList1);
        user1.createPlaylist(playList2);
        user2.createPlaylist(playList3);
        playList1.share();
        playList3.share();
        spotifyManager.addUser(user1);
        spotifyManager.addUser(user2);
        int expectedOpenPlaylistsCount = 2;

        int actualOpenPlaylistsCount = spotifyManager.countOpenPlaylists();

        assertThat(actualOpenPlaylistsCount, is(expectedOpenPlaylistsCount));
    }


    @Test
    public void shouldShowOpenPlaylists(){
        SpotifyManagerDouble spotifyManager = new SpotifyManagerDouble();
        User user1 = new User();
        User user2 = new User();
        PlayList playList1 = new PlayList();
        PlayList playList2 = new PlayList();
        PlayList playList3 = new PlayList();
        user1.createPlaylist(playList1);
        user1.createPlaylist(playList2);
        user2.createPlaylist(playList3);
        playList1.share();
        playList3.share();
        spotifyManager.addUser(user1);
        spotifyManager.addUser(user2);

        boolean isShowOpenPlaylistsCalled = spotifyManager.isShowOpenPlaylistsCalled;
    }

}
