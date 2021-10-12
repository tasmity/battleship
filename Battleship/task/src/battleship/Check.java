package battleship;

import java.util.Collections;
import java.util.List;

public class Check extends Game {

    static boolean checkShip(Ships ship, String s1, String s2) {
        int y1 = Ship.parseY(s1);
        int x1 = Ship.parseX(s1);
        int y2 = Ship.parseY(s2);
        int x2 = Ship.parseX(s2);
        return checkCell(y1, x1, y2, x2) && checkTypeLength(ship, checkLength(y1, x1, y2, x2)) &&
                checkPush(y1, x1, y2, x2);
    }

    // проверка является ли корабль нужной формы
    static boolean checkCell(int y1, int x1, int y2, int x2) {
        if (between(y1) && between(x1) && between(y2) && between(x2) &&
                y1 == y2 || x1 == x2) {
            return true;
        }
        System.out.println("\nError! Wrong ship location! Try again:\n");
        return false;
    }

    // проверка входит ли корабль в игровое поле
    static boolean between(int i) {
        return i > 0 && i < 11;
    }

    // проверка соответсвует ли длина заданному кораблю
    static boolean checkTypeLength(Ships ship, int length) {
        if (ship.getCell() != length) {
            System.out.printf("%nError! Wrong length of the %s! Try again:%n%n", ship.getTitle());
        }
        return ship.getCell() == length;
    }

    // проверка свободного места для постановки корабля
    static boolean checkPush(int y1, int x1, int y2, int x2) {
        y1 = y1 == 1 ? y1 : y1 - 1;
        x1 = x1 == 1 ? x1 : x1 - 1;
        y2 = y2 == 10 ? y2 : y2 + 1;
        x2 = x2 == 10 ? x2 : x2 - 1;

        for (var i = y1; i <= y2; i++) {
            for (var j = x1; j <= x2; j++) {
                if (!filed[i][j].equals("~")) {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    return false;
                }
            }
        }
        return true;
    }

    // вычисление длины корабля
    static int checkLength(int y1, int x1, int y2, int x2) {
        return y1 == y2 ? x2 - x1 + 1 : y2 - y1 + 1;
    }

    // поменять строки, если они не в правильном порядке
    static void swapString(List<String> list) {
        Collections.sort(list);
        if (list.get(0).length() == 3) {
            String tmp = list.get(0);
            list.set(0, list.get(1));
            list.set(1, tmp);
        }
    }
}
