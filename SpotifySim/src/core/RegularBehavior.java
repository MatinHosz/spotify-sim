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
        this.setPlayingLimit(this.getPlayingLimit() - 1);
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        if (month < 1)
            throw new InvalidOperatorException("Invalid input. month cannot be less then 1");

        owner.setBehavior(new PremiumBehavior(month));
    }

    public int getPlayingLimit() { return playingLimit; }
    public void setPlayingLimit(int newLimitNumber) {
        playingLimit = newLimitNumber;
    }
}
