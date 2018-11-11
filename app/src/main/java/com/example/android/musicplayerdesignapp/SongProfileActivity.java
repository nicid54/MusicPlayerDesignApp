package com.example.android.musicplayerdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * An Activity that displays the profile of a Song,
 * including the title, artist, album, and album image
 * @author Nicholas Tillinghast-Lewman
 */
public class SongProfileActivity extends AppCompatActivity {

    private boolean isSongPlaying;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_profile);

        //Load the Song Views with the Song Data
        Bundle songBundle = getIntent().getBundleExtra("SONG_BUNDLE");
        Song songFromBundle = getSongFromBundle(songBundle);
        setViewWithSongData(songFromBundle);

        //Add Event Listener to the Play Button and Set up Button State
        addEventListener();
        isSongPlaying = true;
    }


    /**
     * Builds a Song from an input Bundle with Song Data
     * @param songBundle the input Bundle
     * @return the Song from the Bundle
     */
    private Song getSongFromBundle(Bundle songBundle) {

        String titleName = songBundle.getString("titleName");
        String artistName = songBundle.getString("artistName");
        String albumName = songBundle.getString("albumName");
        int albumImage = songBundle.getInt("albumImage");

        return new Song(titleName, artistName, albumName, albumImage);
    }

    /**
     * Populates the Song Profile Views with data from an input Song
     * @param song the input Song
     */
    private void setViewWithSongData(Song song) {

        ((TextView) findViewById(R.id.song_title_name)).setText(song.getTitleName());
        ((TextView) findViewById(R.id.song_artist_name)).setText(song.getArtistName());
        ((TextView) findViewById(R.id.song_album_name)).setText(song.getAlbumName());
        ((ImageView) findViewById(R.id.song_album_image)).setImageResource(song.getAlbumImage());
    }


    /**
     * Adds an Event Listener to the Play ImageButton
     */
    private void addEventListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEventHandler(view);
            }
        };

        (findViewById(R.id.song_play_imagebutton)).setOnClickListener(onClickListener);
        (findViewById(R.id.song_back_imagebutton)).setOnClickListener(onClickListener);
    }


    /**
     * Handles the On-Click Events
     * @param view the view that was clicked
     */
    private void onClickEventHandler(View view) {

        //Play Button Clicked
        if (view.getId() == R.id.song_play_imagebutton) {
            processPlayButtonClick(view);
        } //Back Button Clicked
        else if (view.getId() == R.id.song_back_imagebutton){
            //Load Main Activity
            startActivity(new Intent(this, MainActivity.class));
        }
    }


    /**
     * Handles the PLay and Pause Button images based on the Song play state
     * @param view the view of the ImageButton
     */
    private void processPlayButtonClick(View view) {

        //if the pause button was clicked, show the play button
        if (isSongPlaying) {
            view.setBackgroundResource(R.drawable.button_click_effect_play);
            isSongPlaying = false;
        }
        else { //if the play button was clicked, show the puase button
            view.setBackgroundResource(R.drawable.button_click_effect_pause);
            isSongPlaying = true;
        }
    }
}
