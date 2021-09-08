/**
 * Classe que pode modelar uma reta a partir de dois pontos.
 */
public class SegmentoReta implements ObjetoGeometrico {
    private final double x1;
    private final double x2;
    private final double y1;
    private final double y2;

    /**
     * Construtor que gera uma reta a partir de 2 pontos.
     *
     * @param p1 ponto 1 da reta
     * @param p2 ponto 2 da reta
     */
    public SegmentoReta(Ponto p1, Ponto p2) {
        this.x1 = p1.getCoordX();
        this.x2 = p2.getCoordX();
        this.y1 = p1.getCoordY();
        this.y2 = p2.getCoordY();
    }

    public double comprimento() {
        return Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
    }

    /**
     * Metodo que calcula o coeficiente angular de uma reta.
     *
     * @return o coeficiente angular
     */
    public double coeficienteAngular() {
        if ((this.y2 - this.y1) / (this.x2 - this.x1)  == 1) {
            return Double.POSITIVE_INFINITY;
        }
        return (this.y2 - this.y1) / (this.x2 - this.x1);

    }

    public boolean paralelo(SegmentoReta s) {
        return coeficienteAngular() == s.coeficienteAngular();
    }


}
