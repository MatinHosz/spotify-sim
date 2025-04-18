package core;

public class PremiumBehavior implements UserBehavior {
    private int month;

    @Override
    public void createPlaylist(String Title, User Owner) {
        // TODO complete method after completing User and Playlist class
    }

    @Override
    public void playMusic(Music music) {
        // TODO complete method after completing Music class
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
