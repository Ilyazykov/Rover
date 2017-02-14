package netcracker.intensive.rover;

public class Ground {
    private GroundCell[][] groundCells;
    private int width;
    private int height;

    public Ground(int width, int height) {
        this.width = width;
        this.height = height;
        groundCells = new GroundCell[width][height];
    }

    public void initialize(GroundCell ... gc) {
        if (gc.length < width*height) {
            throw new IllegalArgumentException();
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                groundCells[x][y] = gc[x + y*width];
            }
        }
    }

    public GroundCell getCell(int x, int y) throws OutOfGroundException {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            throw new OutOfGroundException();
        }

        return groundCells[x][y];
    }
}
