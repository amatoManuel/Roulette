package Roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Roulette {

    public Number[] number = new Number[37];
    public Bet[] otherPlay = new Bet[4];
    public ArrayList<Player> players;


    public Roulette(){
        this.number[0] = new Number(0, Color.Green);
        this.number[1] = new Number(1, Color.Red);
        for(int i = 3; i<10; i+=2) {
            this.number[i] = new Number(i, Color.Red);
            this.number[i-1] = new Number(i-1, Color.Black);
        }
        this.number[10] = new Number(10, Color.Black);
        for(int i = 12; i<=18; i+=2) {
            this.number[i] = new Number(i, Color.Red);
            this.number[i-1] = new Number(i-1, Color.Black);
        }
        this.number[19] = new Number(19, Color.Red);
        for(int i = 21; i<28; i+=2) {
            this.number[i] = new Number(i, Color.Red);
            this.number[i-1] = new Number(i-1, Color.Black);
        }
        this.number[28] = new Number(28, Color.Black);
        this.number[29] = new Number(29, Color.Black);
        for(int i = 31; i<36; i+=2) {
            this.number[i] = new Number(i, Color.Black);
            this.number[i-1] = new Number(i-1, Color.Red);
        }
        this.number[36] = new Number(36, Color.Red);
        players = new ArrayList<Player>();
        for(int i = 0; i<4;i++)
            this.otherPlay[i]=new Bet();

    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void betColor(Color color, int money, Player player) throws Exception {
        if(money>player.money)
            throw new Exception("Non puoi puntare più soldi di quelli che possiedi");
        player.money-=money;
        if(color==Color.Red)
            this.otherPlay[0].addBet(player,money);
        else
            this.otherPlay[1].addBet(player,money);
    }

    public void betEvenOrOddNumber(boolean evenNumber, int money, Player player) throws Exception {
        if(money>player.money)
            throw new Exception("Non puoi puntare più soldi di quelli che possiedi");
        player.money-=money;
        if(evenNumber)
            this.otherPlay[2].addBet(player,money);
        else
            this.otherPlay[3].addBet(player,money);
    }

    public void betNumber(int number, int money, Player player) throws Exception {
        if(money>player.money)
            throw new Exception("Non puoi puntare più soldi di quelli che possiedi");
        player.money-=money;
        this.number[number].addBet(player,money);

    }

    public String checkWin(){
        int numberDraw = random();
        String win = "E' uscito il numero: "+numberDraw;
        for(int i=0; i<this.number[numberDraw].betPlayers.size(); i++){
            int money = (int) this.number[numberDraw].betMoney.get(i);
            this.number[numberDraw].betPlayers.get(i).money+= (money*36);
            win+="\n"+ this.number[numberDraw].betPlayers.get(i).name+" ha vinto: "+(money*36);
        }
        if(this.number[numberDraw].number == 0)
            return win;
        if(this.number[numberDraw].color == Color.Red)
            for(int i=0; i<this.otherPlay[0].betPlayers.size(); i++){
                int money = (int) this.otherPlay[0].betMoney.get(i);
                this.otherPlay[0].betPlayers.get(i).money+= money*2;
                win+="\n"+ this.otherPlay[0].betPlayers.get(i).name+" ha vinto: "+(money*2);
            }
        else
            for(int i=0; i<this.otherPlay[1].betPlayers.size(); i++){
                int money = (int) this.otherPlay[1].betMoney.get(i);
                this.otherPlay[1].betPlayers.get(i).money+= (money*2);
                win+="\n"+ this.otherPlay[1].betPlayers.get(i).name+" ha vinto: "+(money*2);
            }

        if(this.number[numberDraw].number%2==0)
            for(int i=0; i<this.otherPlay[2].betPlayers.size(); i++){
                int money = (int) this.otherPlay[2].betMoney.get(i);
                this.otherPlay[2].betPlayers.get(i).money+= (money*2);
                win+="\n"+ this.otherPlay[2].betPlayers.get(i).name+" ha vinto: "+(money*2);
            }
        else
            for(int i=0; i<this.otherPlay[3].betPlayers.size(); i++){
                int money = (int) this.otherPlay[3].betMoney.get(i);
                this.otherPlay[3].betPlayers.get(i).money+= (money*2);
                win+="\n"+ this.otherPlay[3].betPlayers.get(i).name+" ha vinto: "+(money*2);
            }
            reset();
        return win;
    }


    public int random(){
        Random random = new Random();
        return random.nextInt(36);
    }

    public void reset(){
        for(int i =0; i<this.number.length;i++){
            this.number[i].reset();
        }
        for(int i =0; i<4;i++){
            this.otherPlay[i].reset();
        }
    }



    public enum Color{
        Black ,
        Green ,
        Red
    }

    @Override
    public String toString() {
        return "Roulette{" +
                "number=" + Arrays.toString(number) +
                ", players=" + players +
                '}';
    }
}
