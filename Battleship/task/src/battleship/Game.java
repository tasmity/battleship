package battleship;

import java.util.*;

public class Game extends PlayingField {
    static Scanner scanner = new Scanner(System.in);

    void startGame() {
        pushShips();
        System.out.println("\nThe game starts!\n");
        printField();
        System.out.println("\nTake a shot!\n");
        Hit.hit(scanner.next());
    }

    // постановка кораблей на поле
    void pushShips() {
        printField();
        for (Ships s : Ships.values()) {
            boolean pushShip = false;
            List<String> list = new ArrayList<>();
            System.out.printf("%nEnter the coordinates of the %s (%d cells):%n%n", s.getTitle(), s.getCell());
            while (!pushShip) {
                list.add(scanner.next());
                list.add(scanner.next());
                Check.swapString(list);
                if (Check.checkShip(s, list.get(0), list.get(1))) {
                    pushShip = true;
                } else {
                    list.clear();
                }
            }
            new Ship(s, list.get(0), list.get(1));
            printField();
        }
    }
}
