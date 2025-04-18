package core;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        throw new InvalidOperatorException("Playlist creation is only available for premium users.");
    }

    @Override
    public void playMusic(Music music) {
        if (this.getPlayingLimit() <= 0)
            throw new InvalidOperatorException("You have reached your play limit.");
        // TODO complete method after completing Music class
    }

    @Override
    public void buyPremium(User owner, int month) {
        // TODO complete method after completing User class
    }

    public int getPlayingLimit() { return playingLimit; }
    public void setPlayingLimit(int newLimitNumber) {
        playingLimit = newLimitNumber;
    }
}
