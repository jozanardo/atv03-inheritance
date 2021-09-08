/**
 * Classe que gera um circulo a partir de uma raio e um ponto central.
 */
public class Circulo extends Elipse {
    protected final double raio;

    /**
     * Construtor que gera um circulo.
     *
     * @param centro ponto central do circulo
     * @param raio raio do circulo
     */
    public Circulo(Ponto centro, double raio) {
        super(centro, raio, raio);
        this.raio = raio;

    }

    @Override
    public double circunferencia() {
        return 2 * Math.PI * raio;
    }

    @Override
    public double largura() {
        return 2 * raio;
    }

    @Override
    public double altura() {
        return 2 * raio;
    }

    @Override
    public double area() {
        return  Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double perimetro() {
        return circunferencia();
    }
}
