/**
 * Classe que gera um Trapezio a partir de 4 pontos distintos.
 */
public class Trapezio extends Quadrilatero {

    public Trapezio(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
    }

    /**
     * Metodo que compara 2 segmentos de reta retornando o menor segmento.
     *
     * @return a menor base
     */
    public SegmentoReta baseMenor() {
        SegmentoReta basep1p2 = new SegmentoReta(p1, p2);
        SegmentoReta basep3p4 = new SegmentoReta(p3, p4);
        if (basep1p2.comprimento() > basep3p4.comprimento()) {
            return basep3p4;
        }
        return basep1p2;
    }

    /**
     * Metodo que compara 2 segmentos de reta retornando o maior segmento.
     *
     * @return a maior base
     */
    public SegmentoReta baseMaior() {
        SegmentoReta basep1p2 = new SegmentoReta(p1, p2);
        SegmentoReta basep3p4 = new SegmentoReta(p3, p4);
        if (basep1p2.comprimento() > basep3p4.comprimento()) {
            return basep1p2;
        }
        return basep3p4;
    }

    /**
     * Metodo que verifica a existencia de um trapezio.
     *
     * @param p1 ponto 1 do trapezio
     * @param p2 ponto 2 do trapezio
     * @param p3 ponto 3 do trapezio
     * @param p4 ponto 4 do trapezio
     * @return "true" caso exista ou "false" caso não exista
     */
    public static boolean existe(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        SegmentoReta basep1p2 = new SegmentoReta(p1, p2);
        SegmentoReta basep4p3 = new SegmentoReta(p4, p3);
        return basep1p2.paralelo(basep4p3) && !basep1p2.equals(basep4p3);
    }

    @Override
    public double largura() {
        return baseMaior().comprimento();
    }

    @Override
    public double area() {
        return (baseMaior().comprimento() + baseMenor().comprimento()) * super.altura() / 2;
    }

}
