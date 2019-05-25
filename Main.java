package Roulette;

import java.util.Scanner;

public class Main {

    public  static  void  main  (String[]  args){
        Roulette roulette = new Roulette();
        int choice=0;
        int money;
        int money1,number;
        String name;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Menu");
            System.out.println("1-Aggiungi giocatore");
            System.out.println("2-Punta");
            System.out.println("3-Stampa player");
            System.out.println("0-Esci");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Inserisci nome");
                    name= input.next();
                    System.out.println("Inserisci soldi");
                    money= input.nextInt();
                    roulette.addPlayer(new Player(name,money));
                    break;

                case 2:
                    for (int i =0; i<roulette.players.size();i++){
                        Player player = roulette.players.get(i);
                        System.out.println(player.name+"\nDove vuoi puntare\n1-Colori\n2-Numeri pari o dispari\n3-Numeri");
                        choice = input.nextInt();
                        switch (choice){
                            case 1:
                                System.out.println("Quanti soldi vuoi puntare");
                                money=input.nextInt();
                                System.out.println("Vuoi punare sul:\n1-Rosso\n2-Nero");
                                choice=input.nextInt();
                                try {
                                    if (choice == 1)
                                        roulette.betColor(Roulette.Color.Red, money, player);
                                    else
                                        roulette.betColor(Roulette.Color.Black, money, player);
                                }catch (Exception e){
                                    System.out.println(e);
                                    i--;
                                }
                                break;

                            case 2:
                                System.out.println("Quanti soldi vuoi puntare");
                                money=input.nextInt();
                                System.out.println("Vuoi punare sui numeri :\n1-Pari\n2-Dispari");
                                choice=input.nextInt();
                                try {
                                    if (choice == 1)
                                        roulette.betEvenOrOddNumber(true, money, player);
                                    else
                                        roulette.betEvenOrOddNumber(false, money, player);
                                }catch (Exception e){
                                    System.out.println(e);
                                    i--;
                                }
                                break;

                            case 3:
                                System.out.println("Inserisci numero");
                                number= input.nextInt();
                                System.out.println("Quanti soldi vuoi puntare");
                                money1= input.nextInt();
                                try {
                                    roulette.betNumber(number, money1, player);
                                }catch (Exception e){
                                    System.out.println(e);
                                    i--;
                                }
                                break;
                        }
                    }
                    System.out.println(roulette.checkWin());
                    break;
                case 3:
                    System.out.println(roulette.players);
                    break;
                case 0:break;
            }

        }while(choice!=0);
    }
}
