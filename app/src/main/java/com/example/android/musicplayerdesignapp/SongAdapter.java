package com.example.android.musicplayerdesignapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Custom ArrayAdapter that displays a tracklist of Songs
 * @author Nicholas Tillinghast-Lewman
 */
public class SongAdapter extends ArrayAdapter<Song> {

    private View.OnClickListener mOnClickListener;
    private View mLastSelectedView;
    private int mSelectedViewPosition;

    /**
     * Custom constructor that calls the ArrayAdapter constructor with the input Song ArrayList
     * @param context the current Activity
     * @param trackList the ArrayList containing the list of songs in the track list
     */
    SongAdapter(Activity context, ArrayList<Song> trackList) {
        super(context, 0, trackList);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHandler(view);
            }
        };
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        //Check to see if the View is not being reused
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item,parent,false);
            listItemView.setOnClickListener(mOnClickListener);

            //Set the ID of the View to be the position in the Song Array List
            listItemView.setId(position);

            //Set the default selected view to be the first item
            if (position == 0) {
                onClickHandler(listItemView);
            }
        }

        //Get the current Song and populate the current View with the Song data
        Song currentSong = getItem(position);
        assert currentSong != null;

        TextView textViewTitleName = listItemView.findViewById(R.id.title_name_text_view);
        String titleString = getContext().getString(R.string.title) + currentSong.getTitleName();
        textViewTitleName.setText(titleString);

        TextView textViewArtistName = listItemView.findViewById(R.id.artist_name_text_view);
        String artistString = getContext().getString(R.string.artist) + currentSong.getArtistName();
        textViewArtistName.setText(artistString);

        return listItemView;
    }

    /**
     * Handles the tracklist selection when a ListView item is clicked
     * @param view the selected view
     */
    private void onClickHandler(View view) {

        if (mLastSelectedView != null) {
            mLastSelectedView.setBackgroundColor(Color.WHITE);
        }

        view.setBackgroundColor(ContextCompat.getColor(this.getContext(), R.color.colorSalmon));
        mLastSelectedView = view;
        mSelectedViewPosition = view.getId();
    }

    /**
     * Returns the position of the array index for the Song of the currently selected Song View
     * @return the selected view index
     */
    public int getSelectedViewPosition() {
        return mSelectedViewPosition;
    }
}
