package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static List<Coin> coins = initCoins(10);

    public static void main(String[] args) {

        Player player1 = new Player("kuyo", 0);
        Player player2 = new Player("nayo", 0);
        System.out.println(coins);

        while(!isGameOver(coins)){
            playerMove(player1);
            if(isGameOver(coins)){
                break;
            }
            playerMove(player2);
        }

        whoWonGame(player1, player2);

    }


    public static List<Coin> initCoins(int size){
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < size; i++){
            coins.add(Coin.HEAD);
        }
        return coins;
    }

    public static boolean isGameOver(List<Coin> coins) {
        for(int i = 0; i < coins.size();i++){
            if(coins.get(i) == Coin.HEAD){
                return false;
            }
        }
        return true;
    }

    public static void playerMove(Player player)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getUsername() + ": Enter the number of turns");
        int numOfFlips = scanner.nextInt();


        while(numOfFlips <= 0 || numOfFlips > 3 ){
            try {
                throw new TurnException();
            } catch (TurnException ex) {
                ex.printStackTrace();
            }
            System.out.println(player.getUsername() + ": Enter the number of turns");
            numOfFlips = scanner.nextInt();
        }

        for (int i = 0; i < numOfFlips; i++) {
            System.out.println(player.getUsername() + ": Enter the column");
            int columnOfCoin = scanner.nextInt();
            if(columnOfCoin - 1 >= coins.size()){
                try {
                    throw new TurnException();
                } catch (TurnException ex) {
                    ex.printStackTrace();
                }
                i--;
            }
            else if(coins.get(columnOfCoin - 1) == Coin.TAIL && columnOfCoin != coins.size()){
                coins.remove(columnOfCoin - 1);
                coins.add(columnOfCoin - 1, Coin.HEAD);
            }
            else if(coins.get(columnOfCoin - 1) == Coin.TAIL && columnOfCoin == coins.size()){
                try {
                    throw new TurnException();
                } catch (TurnException ex) {
                    ex.printStackTrace();
                }
                i--;
            }
            else{
                coins.remove(columnOfCoin - 1);
                coins.add(columnOfCoin - 1, Coin.TAIL);
            }
        }

        player.setCoinState(new ArrayList<Coin>(coins));
        System.out.println(coins);
    }

    public static void whoWonGame(Player player1, Player player2){
        if(isGameOver(player1.getCoinState())){
            System.out.println(player1.getUsername() + " won the game!!!");
            player1.setScore(player1.getScore() + 1);
        }
        else{
            System.out.println(player2.getUsername() + " won the game!!!");
            player2.setScore(player2.getScore() + 1);
        }
    }
}
