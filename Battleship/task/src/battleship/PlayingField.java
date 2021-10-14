package battleship;

import java.util.Arrays;

public class PlayingField {
    static String[][] filed1 = new String[11][11];
    static String[][] filed2 = new String[11][11];

    PlayingField() {
        initialize(filed1);
        initialize(filed2);
    }

    // Иниациализация игрового поля
    static void initialize(String[][] filed) {
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
    static void printField(String[][] filed) {
        for (String[] y : filed) {
            Arrays.stream(y).forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
