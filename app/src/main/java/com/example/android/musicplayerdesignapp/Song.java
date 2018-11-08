package com.example.android.musicplayerdesignapp;
import android.support.annotation.NonNull;

/**
 * A class containing a song's data: song title, artist's name, album name and album image number
 * @author Nicholas Tillinghast-Lewman
 */
public class Song {
    private String mTitleName;
    private String mArtistName;
    private String mAlbumName;
    private int mAlbumImage;

    /**
     * Constructor for a Song
     * @param titleName the input name of the song title
     * @param artistName the input name of the artist of the song
     * @param albumName the input name of the album of the song
     * @param albumImage the input image number of the album cover
     */
    Song(String titleName, String artistName, String albumName, int albumImage) {
        mTitleName = titleName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mAlbumImage = albumImage;
    }

    /**
     * Gets the song title
     * @return the song title
     */
    public @NonNull String getTitleName() { return mTitleName; }

    /**
     * Gets the artist name of the song
     * @return the artist name
     */
    public @NonNull String getArtistName() {
        return mArtistName;
    }

    /**
     * Gets the album name of the song
     * @return the artist name
     */
    public @NonNull String getAlbumName() {
        return mAlbumName;
    }

    /**
     * Gets the image number of the album cover image
     * @return mAlbumImage the image number
     */
    public int getAlbumImage() {
        return mAlbumImage;
    }
}
