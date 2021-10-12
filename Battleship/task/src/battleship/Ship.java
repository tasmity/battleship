package battleship;

public class Ship {
    int y1;
    int x1;
    int y2;
    int x2;
    String type;
    int length;
    boolean horizontal;


    public Ship(Ships ship, String s1, String s2) {
        this.y1 = parseY(s1);
        this.x1 = parseX(s1);
        this.y2 = parseY(s2);
        this.x2 = parseX(s2);
        this.type = ship.getTitle();
        this.length = ship.getCell();
        this.horizontal = parseType(this.y1, this.y2);
        pushShip(y1, x1, y2, x2);
    }

    // парсинг поля y
    static int parseY(String s) {
        for (Abc c : Abc.values()) {
            if (String.valueOf(s.charAt(0)).equals(c.getTitle())) {
                return c.getRow();
            }
        }
        return 0;
    }

    // парсинг поля x
    static int parseX(String s) {
        return Integer.parseInt(s.substring(1));
    }

    // горизонтальный или вертикальный корабль
    boolean parseType(int y1, int y2) {
        return y1 == y2;
    }

    // Постановка корабля на поле
    void pushShip(int y1, int x1, int y2, int x2) {
        if (horizontal) {
            for (var i = x1; i <= x2; i++) {
                PlayingField.filed[y1][i] = "O";
            }
        } else {
            for (var i = y1; i <= y2; i++) {
                PlayingField.filed[i][x1] = "O";
            }
        }
    }
}
