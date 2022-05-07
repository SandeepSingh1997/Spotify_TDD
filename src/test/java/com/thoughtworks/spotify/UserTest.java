package com.thoughtworks.spotify;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    public void shouldBeAbletoAddAPlayList(){
        User user = new User();
        PlayList playList = new PlayList();
        int expectedPlayListsCount = 1;

        user.addPlaylist(playList);
        int actualPlayListsCount = user.playListsCount();

        assertThat(actualPlayListsCount, is(expectedPlayListsCount));
    }

    @Test
    public void shouldBeAbletoCreateTwoPlaylists(){
        User user = new User();
        PlayList playList1 = new PlayList();
        PlayList playList2 = new PlayList();
        int expectedPlayListsCount = 2;

        user.addPlaylist(playList1);
        user.addPlaylist(playList2);
        int actualPlayListsCount = user.playListsCount();


        assertThat(actualPlayListsCount, is(expectedPlayListsCount));
    }

    @Test
    public void shouldReturnCountOfSharedPlaylistsAsOneWhenThereIsOneSharedPlaylist(){
        User user = new User();
        PlayList playList1 = new PlayList();
        PlayList playList2 = new PlayList();
        playList1.share();
        user.addPlaylist(playList1);
        user.addPlaylist(playList2);
        int expectedSharedPlaylistsCount = 1;

        int actualSharedPlaylistsCount = user.sharedPlayListsCount();

        assertThat(actualSharedPlaylistsCount, is(expectedSharedPlaylistsCount));
    }

    @Test
    public void shouldShowSharedPlaylistsOfTheUser(){
        UserDouble user = new UserDouble();

        user.showSharedPlaylists();
        boolean isShowSharedPlaylistsCalled = user.isShowSharedPlaylistsCalled;

        assertTrue(isShowSharedPlaylistsCalled);
    }

}
