package OOP.View;

import OOP.Abstract.Base;
import OOP.Abstract.States;
import OOP.Characters.Position;
import OOP.Main;

import java.util.Collections;


public class ConsoleView {
    private static final String TOP = "\u256d\u2500" +
            String.join("\u2500", Collections.nCopies(9, "\u252C")) + "\u2500\u256E";
    private static final String BOTTOM = "\u2570\u2500" +
            String.join("\u2500", Collections.nCopies(9, "\u2534")) + "\u2500\u256F";

    public static void viewTop() {
        System.out.println(TOP);
    }
    public static void viewFooter() {
        System.out.println(BOTTOM);
    }

    public static void view() {
        viewTop();
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(new Position(i,j)));
            }
            System.out.print("-> " + Main.whiteSide.get(i).getInfo() +
             "\t" + progressBar((int)Main.whiteSide.get(i).getHealth(), (int)Main.whiteSide.get(i).getMaxHealth()) +
             "\t | " + Main.darkSide.get(i).getInfo() + "\t" +
            progressBar((int)Main.darkSide.get(i).getHealth(), (int)Main.darkSide.get(i).getMaxHealth()));
            System.out.println();

        }
        viewFooter();
    }
    public static String getFirstLetter(Base hero) {
        return hero.getClass().getSimpleName().charAt(0) + "";
    }

    public static String getChar(Position position) {
        String str = "| ";
        for (int i = 0; i < 10; i++) {
            boolean alive = true;
            if (Main.whiteSide.get(i).getPosition().isEqual(position)) {
                if (Main.whiteSide.get(i).getState()==States.DEAD) {
                    alive=false;
                    str = AnsiColors.ANSI_RED + getFirstLetter(Main.whiteSide.get(i)) + AnsiColors.ANSI_RESET;
                }
                else str = AnsiColors.ANSI_BLUE + getFirstLetter(Main.whiteSide.get(i)) + AnsiColors.ANSI_RESET;
            }
            if (Main.darkSide.get(i).getPosition().isEqual(position) && alive) {
                if (Main.darkSide.get(i).getState().equals(States.DEAD))
                    str = "|" + AnsiColors.ANSI_RED + getFirstLetter(Main.darkSide.get(i)) + AnsiColors.ANSI_RESET + "|";
                else str = "|" + AnsiColors.ANSI_GREEN + getFirstLetter(Main.darkSide.get(i)) + AnsiColors.ANSI_RESET + "|";
            }
        }

        return str;
    }

    public static String progressBar(int remain, int total) {
        int maxBarSize = 10;
        int remainPercent = ((100*remain)/total/maxBarSize);
        char defaultChar = '-';
        String icon = "*";
        String bar = new String(new char[maxBarSize]).replace('\0', defaultChar) + "]";
        String barDone = "[" +
                icon.repeat(Math.max(0, remainPercent));
        String barRemain = bar.substring(remainPercent);
        return barDone +barRemain+" "+remainPercent*10+"%";

    }
}
