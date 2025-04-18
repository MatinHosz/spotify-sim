package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Music {
    private String title;
    private User singer;
    public int numberOfStream;

    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer) {
        try {
            repetitiveMusic(title, singer, allMusics);
        } catch (InvalidOperatorException e) {
            throw new InvalidOperatorException(e.getMessage());
        }

        this.setTitle(title);
        this.setSinger(singer);
        this.numberOfStream = 0;

        allMusics.add(this);
    }

    public void play() {
        numberOfStream++;
        System.out.println("Now playing: \"" + getTitle() + "\" by " + getSinger());
    }

    public static List<Music> search(String musicName, ArrayList<Music> musicList) {
        List<Music> searchedMusicList = new ArrayList<>();

        for (Music music : musicList) {
            if (Objects.equals(music.title, musicName))
                searchedMusicList.add(music);
        }
        if (searchedMusicList.isEmpty())
            return null;
        return searchedMusicList;
    }

    public static Music search(String musicName, String singerName, ArrayList<Music> musicList) {
        for (Music music : musicList) {
            if (Objects.equals(music.title, musicName) && Objects.equals(music.singer.getUsername(), singerName))
                return music;
        }
        return null;
    }

    public String getTitle() { return title; }
    public void setTitle(String newTitle) {
        if (newTitle == null || newTitle.isEmpty())
            throw new InvalidOperatorException("Invalid input. title cannot be null or empty.");

        this.title = newTitle;
    }

    public User getSinger() { return singer; }
    public void setSinger(User singer) {
        this.singer = singer;
    }

    public int getNumberOfStream() { return numberOfStream; }

    public static void repetitiveMusic(String title, User singer, ArrayList<Music> musicList) {
        for (Music music : musicList) {
            if (Objects.equals(music.title, title) && Objects.equals(music.singer, singer))
                throw new InvalidOperatorException("This music already exists with the same title and singer.");
        }
    }
}
