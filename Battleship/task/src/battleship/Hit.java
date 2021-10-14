package battleship;

import static battleship.PlayingField.filed1;
import static battleship.PlayingField.filed2;

public class Hit {
    private Hit() {
    }

    // проверка ячейки удара
    static void hit(String hit) {
        int y = Ship.parseY(hit);
        int x = Ship.parseX(hit);
        if (!Check.between(y) || !Check.between(x)) {
            System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
            hit(Game.scanner.next());
        } else {
            pushHit(y, x);
        }
    }

    // заполнение ячейки удара
    static void pushHit(int y, int x) {
        if (filed1[y][x].equals("O")) {
            filed1[y][x] = "X";
            filed2[y][x] = "X";
            PlayingField.printField(filed2);
            System.out.println("\nYou hit a ship!\n");
        } else {
            filed1[y][x] = "M";
            filed2[y][x] = "M";
            PlayingField.printField(filed2);
            System.out.println("\nYou missed!\n");
        }
        PlayingField.printField(filed1);
    }
}
