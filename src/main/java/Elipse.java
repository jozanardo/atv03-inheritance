/**
 * Eh uma classe que gera uma elipse a partir de um ponto central e dois semi-eixos.
 */
public class Elipse implements FormaGeometrica {
    protected final Ponto centro;
    protected final double semiEixoA;
    protected final double semiEixoB;

    /**
     * Construtor que gera a Elipse.
     *
     * @param centro ponto central da elipse
     * @param semiEixoA semi-eixo na horizontal
     * @param semiEixoB semi-eixo na vertical
     */
    public Elipse(Ponto centro, double semiEixoA, double semiEixoB) {
        this.centro = centro;
        if (semiEixoA < 0 || semiEixoB < 0) {
            throw new IllegalArgumentException("semiEixo's must be greater than 0");
        }
        this.semiEixoA = semiEixoA;
        this.semiEixoB = semiEixoB;
    }

    /**
     * Metodo que compara 2 semi-eixos e retorna o menor.
     *
     * @return o menor semi-eixo
     */
    public double getEixoSemiMenor() {
        if (semiEixoA > semiEixoB) {
            return semiEixoB;
        }
        return semiEixoA;
    }

    /**
     * Metodo que compara 2 semi-eixos e retorna o maior.
     *
     * @return o maior semi-eixo
     */
    public double getEixoSemiMaior() {
        if (semiEixoA < semiEixoB) {
            return semiEixoB;
        }
        return semiEixoA;
    }

    public double circunferencia() {
        return 2 * Math.PI * Math.sqrt((Math.pow(semiEixoA, 2) + Math.pow(semiEixoB, 2)) / 2);
    }

    @Override
    public double largura() {
        return 2 * semiEixoA;
    }

    @Override
    public double altura() {
        return 2 * semiEixoB;
    }

    @Override
    public double area() {
        return Math.PI * semiEixoB * semiEixoA;
    }

    @Override
    public double perimetro() {
        return circunferencia();
    }
}
