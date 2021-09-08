/**
 * Classe que gera um Triangulo a partir de 3 pontos distintos.
 */
public class Triangulo extends Poligono {

    private final Ponto p1;
    private final Ponto p2;
    private final Ponto p3;

    /**
     * Construtor que gera um triangulo.
     *
     * @param p1 ponto 1 do triangulo
     * @param p2 ponto 2 do triangulo
     * @param p3 ponto 3 do triangulo
     */
    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        super(new Ponto[]{p1, p2, p3});
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double largura() {
        SegmentoReta x = new SegmentoReta(p2, p3);
        return x.comprimento();
    }

    @Override
    public double altura() {
        SegmentoReta a = new SegmentoReta(
                         new Ponto(p1.getCoordX(), p1.getCoordY()),
                         new Ponto(p1.getCoordX(), p2.getCoordY()));
        return a.comprimento();
    }

    @Override
    public double area() {
        return largura() * altura() / 2;
    }

    @Override
    public double perimetro() {
        SegmentoReta p1p2 = new SegmentoReta(p1, p2);
        SegmentoReta p1p3 = new SegmentoReta(p1, p3);
        return largura() + p1p3.comprimento() + p1p2.comprimento();
    }

}
