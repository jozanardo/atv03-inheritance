/**
 * Classe que gera um Quadrilatero a partir de 4 pontos distintos.
 */
public class Quadrilatero extends Poligono {

    protected final Ponto p1;
    protected final Ponto p2;
    protected final Ponto p3;
    protected final Ponto p4;

    /**
     * Construtor que gera um Quadrilatero.
     *
     * @param p1 ponto 1 do Quadrilatero
     * @param p2 ponto 2 do Quadrilatero
     * @param p3 ponto 3 do Quadrilatero
     * @param p4 ponto 4 do Quadrilatero
     */
    public Quadrilatero(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(new Ponto[]{p1, p2, p3, p4});
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    @Override
    public double area() {
        Triangulo triangulo1 = new Triangulo(p1, p2, p3);
        Triangulo triangulo2 = new Triangulo(p2, p3, p4);
        return triangulo1.area() + triangulo2.area();
    }

    @Override
    public double altura() {
        return  Math.abs(p2.getCoordY() - p3.getCoordY());
    }

    @Override
    public double largura() {
        return p3.getCoordX() - p4.getCoordX();
    }

    @Override
    public double perimetro() {
        SegmentoReta p1p2 = new SegmentoReta(p1, p2);
        SegmentoReta p2p3 = new SegmentoReta(p2, p3);
        SegmentoReta p3p4 = new SegmentoReta(p3, p4);
        SegmentoReta p4p1 = new SegmentoReta(p4, p1);
        return p1p2.comprimento() + p2p3.comprimento() + p3p4.comprimento() + p4p1.comprimento();
    }
}
