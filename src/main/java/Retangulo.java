/**
 * Classe que gera um retangulo a partir de 4 pontos distintos.
 */
public class Retangulo extends  Paralelogramo {

    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
    }

    public boolean quadrado() {
        return Math.abs(altura() - largura()) < 0.0001;
    }

    /**
     * Metodo que verifica a existencia de um retangulo.
     *
     * @param p1 ponto 1 do retangulo
     * @param p2 ponto 2 do retangulo
     * @param p3 ponto 3 do retangulo
     * @param p4 ponto 4 do retangulo
     * @return "true" caso exista ou "false" caso não existe
     */
    public static boolean existe(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        SegmentoReta basep1p2 = new SegmentoReta(p1, p2);
        SegmentoReta basep4p3 = new SegmentoReta(p4, p3);
        SegmentoReta lateralp1p4 = new SegmentoReta(p1, p4);
        SegmentoReta lateralp2p3 = new SegmentoReta(p2, p3);

        return Math.abs(basep1p2.comprimento() - basep4p3.comprimento()) < 0.00001
               && Math.abs(lateralp1p4.comprimento() - lateralp2p3.comprimento()) < 0.00001;
    }
}
