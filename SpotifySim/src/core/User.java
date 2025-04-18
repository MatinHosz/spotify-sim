package core;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private UserBehavior behavior;

    public ArrayList<User> followerList = new ArrayList<>();
    public ArrayList<User> followingList = new ArrayList<>();
    public ArrayList<Playlist> playlists = new ArrayList<>();
    public static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        this.behavior = new RegularBehavior();

        allUsers.add(this);
    }

    public void follow(User user) {
        followingList.add(user);
        user.followerList.add(this);
    }
    public void createPlaylist(String title) {
        this.behavior.createPlaylist(title, this);
    }
    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }
    public void buyPremium(User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }

    public String getUsername() { return username; }
    public void setUsername(String newUsername) {
        if(newUsername == null || newUsername.isEmpty())
            throw new InvalidOperatorException("Invalid input. username cannot be null or empty.");

        for (User user: allUsers) {
            if (Objects.equals(user.getUsername(), newUsername))
                throw new InvalidOperatorException("User with this username already exist.");
        }

        this.username = newUsername;
    }

    public String getPassword() { return password; }
    public void setPassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty())
            throw new InvalidOperatorException("Invalid input. password cannot be null or empty.");
        if (newPassword.length() < 8)
            throw new InvalidOperatorException("password length should not be less then 8.");

        this.password = newPassword;
    }
    public UserBehavior getBehavior() { return behavior; }
    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
}
