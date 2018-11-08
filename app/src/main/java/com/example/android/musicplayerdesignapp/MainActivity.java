package com.example.android.musicplayerdesignapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * The Main Activity that displays a list of Songs in a custom ArrayAdapter
 * @author Nicholas Tillinghast-Lewman
 * Note: All art assets courtesy of kisscc0.com and is royalty free
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> mTrackList;
    private SongAdapter mTrackListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the track list of Songs and displays it
        initTrackList();
        displayTrackList();

        //Set up Event Listeners
        addEventListener();
    }

    /**
     * Initializes the song tracklist with Song data
     */
    private void initTrackList() {
        mTrackList = new ArrayList<>();
        mTrackList.add(new Song("A Doggy Bag of Love",
                                "The Hound Dogs",
                                "Canine Dreams",
                                R.drawable.album_image_dog));

        mTrackList.add(new Song("A Saucer of Love",
                                "The Cantankerous Kittens",
                                "Feline Fantasies",
                                R.drawable.album_image_cat));

        mTrackList.add(new Song("A Cracker of Love",
                                "The Mighty Macaws",
                                "Avian Wings",
                                R.drawable.album_image_parrot));

        mTrackList.add(new Song("A Paddock of Love",
                                "That's Udder Bull",
                                "Bovine Creams",
                                R.drawable.album_image_cow));

        mTrackList.add(new Song("Eucalyptus of Love",
                                "The Krazy Koalas",
                                "Marsupial Dreams",
                                R.drawable.album_image_koala));

        mTrackList.add(new Song("A Lillipad of Love",
                                "The Fanatical Frogs",
                                "Amphibian Mirage",
                                R.drawable.album_image_frog));

    }

    /**
     * Creates a SongAdapter with the input tracklist and displays the data
     */
    private void displayTrackList() {

        mTrackListAdapter = new SongAdapter(this, mTrackList);
        ListView songListView = findViewById(R.id.song_list_view);
        songListView.setAdapter(mTrackListAdapter);
    }

    /**
     * Adds an Event Listener to the Play ImageButton
     */
    public void addEventListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler();
            }
        };

        (findViewById(R.id.main_play_imagebutton)).setOnClickListener(onClickListener);
    }

    /**
     * Loads the Song Profile Activity w
     */
    private void onClickHandler() {
        Intent intent = new Intent(this, SongProfileActivity.class);
        Song selectedSong = mTrackList.get(mTrackListAdapter.getSelectedViewPosition());
        intent.putExtra("SONG_BUNDLE", makeSongBundle(selectedSong));
        startActivity(intent);
    }

    /**
     * Builds a Bundle containing Song data
     * @param song the input Song
     * @return the Bundle
     */
    private Bundle makeSongBundle(Song song) {

        Bundle songBundle = new Bundle();
        songBundle.putString("titleName", song.getTitleName());
        songBundle.putString("artistName", song.getArtistName());
        songBundle.putString("albumName", song.getAlbumName());
        songBundle.putInt("albumImage", song.getAlbumImage());

        return songBundle;
    }
}
