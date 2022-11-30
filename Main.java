package OOP;

import OOP.Abstract.Base;
import OOP.Characters.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import static OOP.View.ConsoleView.view;

public class Main {
    public static ArrayList<Base> whiteSide;
    public static ArrayList<Base> darkSide;

    public static void main(String[] args) {
        init();
        while (true) {
            view();
            Scanner sc = new Scanner(System.in);
            String st = sc.nextLine();
            for (int i =0; i < 10; i++) {
                whiteSide.get(i).step(darkSide);
                darkSide.get(i).step(whiteSide);
            }
        }
    }

    public static void init() {
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();
        int x = 0;
        int y = 0;

        for (int i = 0; i < 10; i++) {
            int randomNum = (int)(Math.random()*4);
            switch (randomNum) {
                case 0 -> whiteSide.add(new Monk(darkSide, x++, y));
                case 1 -> whiteSide.add(new Peasant(darkSide, x++, y));
                case 2 -> whiteSide.add(new Robber(darkSide, x++, y));
                default -> whiteSide.add(new Sniper(darkSide, x++, y));
            }
        }

        x = 0;
        y = 9;

        for (int i = 0; i < 10; i++) {
            int randomNum = (int)(Math.random()*4);
            switch (randomNum) {
                case 0 -> darkSide.add(new Peasant(whiteSide, x++, y));
                case 1 -> darkSide.add(new Spearman(whiteSide, x++, y));
                case 2 -> darkSide.add(new Wizard(whiteSide, x++, y));
                default -> darkSide.add(new Xbowman(whiteSide, x++, y));
            }
        }


    }
}
