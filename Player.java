package Roulette;

public class Player {

    public String name;
    public int money;


    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
