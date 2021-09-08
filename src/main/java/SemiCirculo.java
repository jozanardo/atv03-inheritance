/**
 * Classe que gera um semi Circulo a partir de um ponto central e um raio.
 */
public class SemiCirculo implements FormaGeometrica {
    protected final Ponto centro;
    protected final double raio;

    public SemiCirculo(Ponto centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }

    @Override
    public double largura() {
        return 2 * raio;
    }

    @Override
    public double altura() {
        return raio;
    }

    @Override
    public double area() {
        return (Math.PI * Math.pow(raio, 2)) / 2;
    }

    @Override
    public double perimetro() {
        return raio * (Math.PI  + 2);
    }
}
