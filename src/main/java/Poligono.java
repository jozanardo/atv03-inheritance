/**
 * Classe que gera um vetor de pontos que um poligono pode ter.
 */
public abstract class Poligono implements FormaGeometrica {

    Ponto[] ponto;

    public Poligono(Ponto[] pontos) {
        this.ponto = pontos;
    }

    public Ponto[] getPonto() {
        return ponto;
    }

    public void setPonto(Ponto[] ponto) {
        this.ponto = ponto;
    }
}
