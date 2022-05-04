package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.SongAlreadyPresentInThePlayListException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class PlayListTest {
    @Test
    public void shouldBeAbleToAddASongToThePlayList() throws SongAlreadyPresentInThePlayListException {
        PlayList playList = new PlayList();
        Song song = new Song();
        int expectedSongsCount = 1;

        playList.addSong(song);
        int actualSongsCount = playList.songsCount();

        assertThat(actualSongsCount, is(expectedSongsCount));
    }

    @Test
    public void shouldNotBeAbleToAddSongToThePlaylistIfTheSongAlreadyExists() throws SongAlreadyPresentInThePlayListException {
        PlayList playList = new PlayList();
        Song song = new Song();
        playList.addSong(song);

        assertThrows(SongAlreadyPresentInThePlayListException.class, ()->{
            playList.addSong(song);
        });
    }
}
