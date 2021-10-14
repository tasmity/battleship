package battleship;

import java.util.Arrays;

public class PlayingField {
    static String[][] filed = new String[11][11];

    PlayingField() {
        initialize();
    }

    // Иниациализация игрового поля
    static void initialize() {
        for (String[] cell : filed) {
            Arrays.fill(cell, "~");
        }
        for (int y = 1; y < filed.length; y++) {
            char cr = 'A';
            for (var x = 1; x < filed[0].length; x++) {
                filed[0][x] = Integer.toString(x);
                filed[x][0] = Character.toString(cr++);
            }
        }
        filed[0][0] = " ";
    }

    // Вываод игрового поля на экран
    static void printField() {
        for (String[] y : filed) {
            Arrays.stream(y).forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
