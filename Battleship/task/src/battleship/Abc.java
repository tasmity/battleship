package battleship;

public enum Abc {
    A("A", 1),
    B("B", 2),
    C("C", 3),
    D("D", 4),
    E("E", 5),
    F("F", 6),
    G("G", 7),
    H("H", 8),
    I("I", 9),
    J("J", 10);

    private final int row;
    private final String title;

    Abc(String title, int row) {
        this.row = row;
        this.title = title;
    }

    public int getRow() {
        return row;
    }

    public String getTitle() {
        return title;
    }
}
