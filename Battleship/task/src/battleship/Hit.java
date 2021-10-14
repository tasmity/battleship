package battleship;

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
        if (PlayingField.filed[y][x].equals("O")) {
            PlayingField.filed[y][x] = "X";
            PlayingField.printField();
            System.out.println("\nYou hit a ship!");
        } else {
            PlayingField.filed[y][x] = "M";
            PlayingField.printField();
            System.out.println("\nYou missed!");
        }
    }
}
