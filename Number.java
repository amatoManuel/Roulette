package Roulette;


public class Number extends Bet{

    public int number;
    public Roulette.Color color;


    public Number(int number, Roulette.Color color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                ", color=" + color +
                '}';
    }

}
