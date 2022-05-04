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

}
