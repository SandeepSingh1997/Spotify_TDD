package com.thoughtworks.spotify;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpotifyManagerTest {
    @Test
    public void shouldBeAbleToAddUser(){
        SpotifyManager spotifyManager = new SpotifyManager();
        User user = new User(1);
        int expectedUsersCount = 1;

        spotifyManager.addUser(user);
        int actualUsersCount = spotifyManager.userCount();

        assertThat(actualUsersCount, is(expectedUsersCount));
    }

    @Test
    public void shouldReturnCountOfOpenPlaylistsAsTwoWhenTwoPlaylistsAreShared(){
        SpotifyManager spotifyManager = new SpotifyManager();
        User user1 = new User(1);
        User user2 = new User(2);
        PlayList playList1 = new PlayList(1);
        PlayList playList2 = new PlayList(2);
        PlayList playList3 = new PlayList(3);
        user1.addPlaylist(playList1);
        user1.addPlaylist(playList2);
        user2.addPlaylist(playList3);
        playList1.share();
        playList3.share();
        spotifyManager.addUser(user1);
        spotifyManager.addUser(user2);
        int expectedOpenPlaylistsCount = 2;

        int actualOpenPlaylistsCount = spotifyManager.countOpenPlaylists();

        assertThat(actualOpenPlaylistsCount, is(expectedOpenPlaylistsCount));
    }


    @Test
    public void shouldReturnOpenPlaylists() throws CloneNotSupportedException {
        SpotifyManager spotifyManager = new SpotifyManager();
        User user1 = new User(1);
        User user2 = new User(2);
        PlayList playList1 = new PlayList(1);
        PlayList playList2 = new PlayList(2);
        PlayList playList3 = new PlayList(3);
        user1.addPlaylist(playList1);
        user1.addPlaylist(playList2);
        user2.addPlaylist(playList3);
        playList1.share();
        playList3.share();
        List<PlayList> expectedOpenPlaylists = Arrays.asList(playList1, playList3);
        spotifyManager.addUser(user1);
        spotifyManager.addUser(user2);

        List<PlayList> actualOpenPlaylists = spotifyManager.getOpenPlaylists();
        boolean hasAllOpenPlaylists = areTwoPlaylistsSame(actualOpenPlaylists, expectedOpenPlaylists);

        assertTrue(hasAllOpenPlaylists);
    }

    private boolean areTwoPlaylistsSame(List<PlayList> actualOpenPlaylists, List<PlayList> expectedOpenPlaylists) {
        boolean areOpenPlaylists = true;
        for(PlayList playList : actualOpenPlaylists){
            if(!expectedOpenPlaylists.contains(playList)){
                areOpenPlaylists = false;
                break;
            }
        }
        return areOpenPlaylists;
    }


}
