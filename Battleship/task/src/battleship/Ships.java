package battleship;

public enum Ships {
    CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    private final String title;
    private final int cell;

    Ships(String title, int cell) {
        this.title = title;
        this.cell = cell;
    }

    public String getTitle() {
        return title;
    }

    public int getCell() {
        return cell;
    }
}
