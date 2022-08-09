package com.abhisheksingh.linkedlistchallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private final List<Song> songs;

    public Album(String name, String artist) {
        this.songs = new ArrayList<>();
    }

    public void addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
        }
    }

    private Song findSong(String title) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public void addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return;
        }
        System.out.println("This album does not have the track " + trackNumber);
    }

    public void addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return;
        }
        System.out.println("The song " + title + " is not in this album");
    }
}
