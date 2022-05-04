package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.SongAlreadyPresentInThePlaylistException;
import com.thoughtworks.exceptions.SongIsNotPresentInThePlaylistException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class PlayListTest {
    @Test
    public void shouldBeAbleToAddASongToThePlayList() throws SongAlreadyPresentInThePlaylistException {
        PlayList playList = new PlayList();
        Song song = new Song();
        int expectedSongsCount = 1;

        playList.addSong(song);
        int actualSongsCount = playList.songsCount();

        assertThat(actualSongsCount, is(expectedSongsCount));
    }

    @Test
    public void shouldNotBeAbleToAddSongToThePlaylistIfTheSongAlreadyExists() throws SongAlreadyPresentInThePlaylistException {
        PlayList playList = new PlayList();
        Song song = new Song();
        playList.addSong(song);

        assertThrows(SongAlreadyPresentInThePlaylistException.class, ()->{
            playList.addSong(song);
        });
    }

    @Test
    public void shouldBeAbleToRemoveAnExistingSongFromThePlayList() throws SongAlreadyPresentInThePlaylistException, SongIsNotPresentInThePlaylistException {
        PlayList playList = new PlayList();
        Song song = new Song();
        playList.addSong(song);
        int expectedSongsCount = 0;

        playList.removeSong(song);
        int actualSongsCount = playList.songsCount();

        assertThat(actualSongsCount, is(expectedSongsCount));
    }

    @Test
    public void shouldNotBeAbleToRemoveASongFromThePlaylistWhenItDoesNotExistInThePlayList(){
        PlayList playList = new PlayList();
        Song song = new Song();

        assertThrows(SongIsNotPresentInThePlaylistException.class, ()->{
            playList.removeSong(song);
        });
    }

    @Test
    public void shouldBeAbleToMakeAPlaylistShared(){
        PlayList playList = new PlayList();

        playList.share();

        assertThat(playList.isShared(), is(true));
    }

}
