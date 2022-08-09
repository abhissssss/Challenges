package com.abhisheksingh.linkedlistchallenge;

import java.util.*;

public class Main {

    private static final List<Album> albums = new ArrayList<>();


    public static void main(String[] args) {
        Album album = new Album("Kohinoor", "Divine");
        album.addSong("Kohinoor", 4.7);
        album.addSong("Chal Bombay", 3.2);
        album.addSong("Wallah", 4.1);
        album.addSong("Gandhi Money", 3.6);
        album.addSong("Vibe hai", 3.82);
        album.addSong("Too Hype", 5.20);
        albums.add(album);

        album = new Album("Moose-tape", "Sidhu-Mosewala");
        album.addSong("Moose-tape", 1.32);
        album.addSong("Burberry", 3.23);
        album.addSong("US", 3.50);
        album.addSong("Moose-drilla", 3.52);
        album.addSong("Real one", 0.44);
        album.addSong("GOAT", 3.34);
        album.addSong("Signed to god ", 2.27);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Wallah", playlist);
        albums.get(0).addToPlaylist("Vibe hai", playlist);
        albums.get(0).addToPlaylist("Too Hype", playlist);
        albums.get(0).addToPlaylist("Chal Bombay", playlist);
        albums.get(1).addToPlaylist(7, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(5, playlist);
        albums.get(1).addToPlaylist(6, playlist);

        play(playlist);


    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist ");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the List");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }


    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("""
                0- to close the app\s
                1 - to play next song \s
                2 - to play previous song \s
                3 - to replay the current song \s
                4 - list songs in the playlist  \s
                5 - print available actions \s
                6 - delete current song from playlist\s
                """);
        System.out.println("Choose your action: ");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("==============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }


}
