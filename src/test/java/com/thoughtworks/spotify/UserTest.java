package com.thoughtworks.spotify;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {
    @Test
    public void shouldBeAbletoCreateAPlayList(){
        User user = new User();
        PlayList playList = new PlayList();
        int expectedPlayListsCount = 1;

        user.createPlaylist(playList);
        int actualPlayListsCount = user.playListsCount();

        assertThat(actualPlayListsCount, equalTo(expectedPlayListsCount));
    }
}
