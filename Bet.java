package Roulette;

import java.util.ArrayList;

public class Bet {

    public ArrayList<Player> betPlayers = new ArrayList<Player>();
    public ArrayList betMoney = new ArrayList();


    public void addBet(Player player, int money){

        this.betPlayers.add(player);
        this.betMoney.add(money);

    }

    public void reset(){
        this.betMoney.clear();
        this.betPlayers.clear();
    }

}
