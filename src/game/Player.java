package game;

import java.util.List;

public class Player {
    private String username;
    private int score;
    private List<Coin> coinState;

    public List<Coin> getCoinState() {
        return coinState;
    }

    public void setCoinState(List<Coin> coinState) {
        this.coinState = coinState;
    }

    public Player(String username, int score, List<Coin> coinState) {
        this.username = username;
        this.score = score;
        this.coinState = Game.initCoins(10);
    }

    public Player(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
