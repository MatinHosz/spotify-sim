package core;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) {
        this.setMonth(month);
    }

    @Override
    public void createPlaylist(String title, User owner) {
        if (title == null || title.isEmpty())
            throw new InvalidOperatorException("Invalid input. title cannot be null or empty.");

        Playlist newPlaylist = new Playlist(owner, title);
        owner.playlists.add(newPlaylist);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        int newMonthNumber = this.getMonth() + month;
        this.setMonth(newMonthNumber);
    }

    public int getMonth() { return month; }
    public void setMonth(int newMonthNumber) {
        this.month = newMonthNumber;
    }
}
