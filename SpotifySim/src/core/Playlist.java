package core;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    public ArrayList<Music> playlist;
    public String title;
    public User owner;

    public Playlist(User owner, String title) {
        playlist = new ArrayList<>();
        this.title = title;
        this.owner = owner;
    }

    public void editTitle(String password, String newTitle) {
        if (newTitle == null || newTitle.isEmpty())
            throw new InvalidOperatorException("Invalid Input. title can not be null or empty.");
        if (password == null || password.isEmpty())
            throw new InvalidOperatorException("Invalid input. password cannot be null or empty.");

        title = newTitle;
    }
    public void addMusic(String password, Music music) {
        try {
            Music.repetitiveMusic(music.getTitle(), music.getSinger(), playlist);
        } catch (InvalidOperatorException e) {
            throw new InvalidOperatorException(e.getMessage());
        }

        playlist.add(music);
    }
    public void removeMusic(String password, Music music) {
        String musicName = music.getTitle();
        String musicSingerName = music.getSinger().getUsername();

        for (Music m: playlist) {
            if (m.getSinger().getUsername().equals(musicSingerName) && music.getTitle().equals(musicName)) {
                playlist.remove(m);
                break;
            }
        }
    }

    public List<Music> searchInPlaylist(String musicName) {
        if (musicName == null || musicName.isEmpty()) {
            throw new InvalidOperatorException("Invalid input. musicName cannot be null or empty.");
        }

        return Music.search(musicName, playlist);
    }
    public Music searchInPlaylist(String musicName, String singerName) {
        if (musicName == null || musicName.isEmpty())
            throw new InvalidOperatorException("Invalid input. musicName cannot be null or empty.");
        if (singerName == null || singerName.isEmpty())
            throw new InvalidOperatorException("Invalid input. singerName cannot be null or empty.");

        return Music.search(musicName, singerName, playlist);
    }

    public void playPlaylist() {
        for (Music music: playlist) {
            music.play();
        }
    }
}
