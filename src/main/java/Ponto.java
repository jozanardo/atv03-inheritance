/**
 * Point class.
 */
public class Ponto implements ObjetoGeometrico {
    private double coordX;
    private double coordY;

    public Ponto(double coordX, double coordY) {
        setCoordX(coordX);
        setCoordY(coordY);
    }

    @Override
    public String toString() {
        return String.format("(%.6f, %.6f)", getCoordX(), getCoordY());
    }

    public Ponto(Ponto ponto) {
        this.coordX = ponto.getCoordX();
        this.coordY = ponto.getCoordY();
    }

    public double getCoordX() {
        return coordX;
    }

    /**
     * Set the x coordinate to a valid value.
     *
     * @param coordX the x coordinate
     */
    private void setCoordX(double coordX) {
        if (coordX < 0.0 || coordX > 1.0) {
            throw  new IllegalArgumentException(String.format(
                "Coordinate must be in [0,1]: %f", coordX));
        }
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    /**
     * Set the y coordinate to a valid value.
     *
     * @param coordY the y coordinate
     */
    private void setCoordY(double coordY) {
        if (coordY < 0.0 || coordY > 1.0) {
            throw  new IllegalArgumentException(String.format(
                "Coordinate must be in [0,1]: %f", coordY));
        }
        this.coordY = coordY;
    }
}
