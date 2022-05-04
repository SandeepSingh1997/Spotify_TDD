package com.thoughtworks.spotify;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserTest {
    @Test
    public void shouldBeAbletoCreateAPlayList(){
        User user = new User();
        PlayList playList = new PlayList();
        int expectedPlayListsCount = 1;

        user.createPlaylist(playList);
        int actualPlayListsCount = user.playListsCount();

        assertThat(actualPlayListsCount, is(expectedPlayListsCount));
    }

    @Test
    public void shouldBeAbletoCreateTwoPlaylists(){
        User user = new User();
        PlayList playList1 = new PlayList();
        PlayList playList2 = new PlayList();
        int expectedPlayListsCount = 2;

        user.createPlaylist(playList1);
        user.createPlaylist(playList2);
        int actualPlayListsCount = user.playListsCount();


        assertThat(actualPlayListsCount, is(expectedPlayListsCount));
    }
}
