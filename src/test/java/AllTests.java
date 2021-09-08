import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * All autograding tests.
 */
public class AllTests {

    private static final String baseDir = "src/test/resources/";
    public static final String circlesFile = baseDir + "circles.csv";
    public static final String semiCirclesFile = baseDir + "semi_circles.csv";
    public static final String ellipsesFile = baseDir + "ellipses.csv";
    public static final String linesFile = baseDir + "lines.csv";
    public static final String trapezoidsFile = baseDir + "trapezoids.csv";
    public static final String parallelogramsFile = baseDir + "parallelograms.csv";
    public static final String rectanglesFile = baseDir + "rectangles.csv";
    public static final String squaresFile = baseDir + "squares.csv";
    public static final String trianglesFile = baseDir + "triangles.csv";

    private static final double delta = 0.001;

    @Test
    public void testEllipses() {
        try (var scanner = new Scanner(new File(ellipsesFile))) {
            var caseNumber = 1;

            while (scanner.hasNext()) {
                final var center = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var semiAxisA = Double.parseDouble(scanner.next());
                final var semiAxisB = Double.parseDouble(scanner.next());
                final var ellipse = new Elipse(center, semiAxisA, semiAxisB);
                final var width = Double.parseDouble(scanner.next());
                final var height = Double.parseDouble(scanner.next());
                final var area = Double.parseDouble(scanner.next());
                final var perimeter = Double.parseDouble(scanner.next());

                System.out.printf("Caso Elipse #%d ", caseNumber++);
                Assertions.assertEquals(width, ellipse.largura(), delta,
                    "Largura da elipse fora do esperado. " + ellipse);
                Assertions.assertEquals(height, ellipse.altura(), delta,
                    "Altura da elipse fora do esperado. " + ellipse);
                Assertions.assertEquals(area, ellipse.area(), delta,
                    "Area da elipse fora do esperado. " + ellipse);
                Assertions.assertEquals(perimeter, ellipse.perimetro(), delta,
                    "Perimetro da elipse fora do esperado. " + ellipse);
                Assertions.assertEquals(perimeter, ellipse.circunferencia(), delta,
                    "Circunferencia da elipse fora do esperado. " + ellipse);
                Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Elipse(center, -1, -1),
                    "Elipse nao deveria aceitar eixo negativo");

                // semi-axis ordering test
                final var ellipse1 = new Elipse(center, semiAxisB, semiAxisA);
                Assertions.assertFalse(ellipse1.getEixoSemiMaior() < ellipse1.getEixoSemiMenor(),
                    String.format("Eixo semi-menor (%f) nao pode exceder eixo semi-maior (%f)",
                        ellipse1.getEixoSemiMenor(), ellipse1.getEixoSemiMaior()));

                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Falha ao abrir o arquivo de casos para elipses");
            e.printStackTrace();
        }
    }

    @Test
    public void testCircles() {
        try (var scanner = new Scanner(new File(circlesFile))) {
            var caseNumber = 1;

            while (scanner.hasNext()) {
                final var center = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var radius = Double.parseDouble(scanner.next());
                final var circle = new Circulo(center, radius);
                final var width = Double.parseDouble(scanner.next());
                final var height = Double.parseDouble(scanner.next());
                final var area = Double.parseDouble(scanner.next());
                final var perimeter = Double.parseDouble(scanner.next());

                System.out.printf("Caso de teste Circulo #%d ", caseNumber++);
                Assertions.assertEquals(width, circle.largura(), delta,
                    "Largura do circulo fora do esperado. " + circle);
                Assertions.assertEquals(height, circle.altura(), delta,
                    "Altura do circulo fora do esperado. " + circle);
                Assertions.assertEquals(area, circle.area(), delta,
                    "Area do circulo fora do esperado. " + circle);
                Assertions.assertEquals(perimeter, circle.perimetro(), delta,
                    "Perimetro do circulo fora do esperado. " + circle);
                Assertions.assertEquals(perimeter, circle.circunferencia(), delta,
                    "Circunferencia do circulo fora do esperado. " + circle);
                Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Circulo(center, -1),
                    "Circulo nao deveria aceitar raio negativo");

                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Falha ao abrir arquivo de testes para circulos");
            e.printStackTrace();
        }
    }

    @Test
    public void testSemiCircles() {
        try (var scanner = new Scanner(new File(semiCirclesFile))) {
            var caseNumber = 1;

            while (scanner.hasNext()) {
                final var center = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var radius = Double.parseDouble(scanner.next());
                final var semiCircle = new SemiCirculo(center, radius);
                final var width = Double.parseDouble(scanner.next());
                final var height = Double.parseDouble(scanner.next());
                final var area = Double.parseDouble(scanner.next());
                final var perimeter = Double.parseDouble(scanner.next());

                System.out.printf("Caso de teste Semi-circulo #%d ", caseNumber++);
                Assertions.assertEquals(width, semiCircle.largura(), delta,
                    "Largura do semi-circulo fora do esperado. " + semiCircle);
                Assertions.assertEquals(height, semiCircle.altura(), delta,
                    "Altura do semi-circulo fora do esperado. " + semiCircle);
                Assertions.assertEquals(area, semiCircle.area(), delta,
                    "Area do semi-circulo fora do esperado. " + semiCircle);
                Assertions.assertEquals(perimeter, semiCircle.perimetro(), delta,
                    "Perimetro do semi-circulo fora do esperado. " + semiCircle);
                Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new Circulo(center, -1),
                    "Semi-circulo nao deveria aceitar raio negativo");

                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Falha ao abrir o arquivo de casos para semi-circulos");
            e.printStackTrace();
        }
    }

    @Test
    public void testLines() {
        try (var scanner = new Scanner(new File(linesFile))) {
            var caseNumber = 1;
            while (scanner.hasNext()) {
                final var point1 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var point2 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var line = new SegmentoReta(point1, point2);
                final var length = Double.parseDouble(scanner.next());
                final var angularCoeff = Double.parseDouble(scanner.next());

                System.out.printf("Caso de teste Segmento de reta #%d ", caseNumber++);
                Assertions.assertEquals(length, line.comprimento(), delta,
                    "Comprimento do segmento de reta fora do esperado. " + line);
                Assertions.assertEquals(angularCoeff, line.coeficienteAngular(), delta,
                    "Coeficiente angular fora do esperado" + line);
                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Falha ao abrir arquivos de casos para segmentos de reta");
            e.printStackTrace();
        }
    }

    @Test
    public void testTrapezoids() {
        try (var scanner = new Scanner(new File(trapezoidsFile))) {
            var caseNumber = 1;

            while (scanner.hasNext()) {
                final var p1 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p2 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p3 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p4 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var trapezoid = new Trapezio(p1, p2, p3, p4);
                final var width = Double.parseDouble(scanner.next());
                final var height = Double.parseDouble(scanner.next());
                final var area = Double.parseDouble(scanner.next());
                final var perimeter = Double.parseDouble(scanner.next());
                final var minorBasis = Double.parseDouble(scanner.next());
                final var majorBasis = Double.parseDouble(scanner.next());

                System.out.printf("Caso de teste Trapezio #%d ", caseNumber++);
                Assertions.assertTrue(Trapezio.existe(p1, p2, p3, p4),
                    "Teste de existencia para trapezio falhou com pontos validos: "
                        + Arrays.toString(new Ponto[]{p1, p2, p3, p4}));
                Assertions.assertEquals(width, trapezoid.largura(), delta,
                    "Largura do trapezio fora do esperado. " + trapezoid);
                Assertions.assertEquals(height, trapezoid.altura(), delta,
                    "Altura do trapezio fora do esperado. " + trapezoid);
                Assertions.assertEquals(area, trapezoid.area(), delta,
                    "Area do trapezio fora do esperado. " + trapezoid);
                Assertions.assertEquals(perimeter, trapezoid.perimetro(), delta,
                    "Perimetro do trapezio fora do esperado. " + trapezoid);
                Assertions.assertEquals(minorBasis, trapezoid.baseMenor().comprimento(), delta,
                    "Base menor do trapezio fora do esperado. " + trapezoid);
                Assertions.assertEquals(majorBasis, trapezoid.baseMaior().comprimento(), delta,
                    "Base maior do trapezio fora do esperado. " + trapezoid);

                System.out.println("OK");
            }

            // negative existence tests
            Ponto[][] falseShapes = {
                {
                    new Ponto(0.2, 0.6),
                    new Ponto(0.1, 0.5),
                    new Ponto(0.9, 0.2),
                    new Ponto(0.3, 0.4)
                },
                {
                    new Ponto(0.2, 0.6),
                    new Ponto(0.1, 0.5),
                    new Ponto(0.4, 0.45),
                    new Ponto(0.3, 0.4)
                }
            };

            for (var points : falseShapes) {
                System.out.printf("Caso de teste Trapezio #%d ", caseNumber++);
                Assertions.assertFalse(Trapezio.existe(
                    points[0], points[1], points[2], points[3]),
                    "Falso positivo no teste de existencia de trapezio"
                        + Arrays.toString(points));
                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Falha ao abrir arquivo de casos para trapezios");
            e.printStackTrace();
        }
    }

    @Test
    public void testParallelograms() {
        try (var scanner = new Scanner(new File(parallelogramsFile))) {
            var caseNumber = 1;

            while (scanner.hasNext()) {
                final var p1 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p2 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p3 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p4 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var parallelogram = new Paralelogramo(p1, p2, p3, p4);
                final var width = Double.parseDouble(scanner.next());
                final var height = Double.parseDouble(scanner.next());
                final var area = Double.parseDouble(scanner.next());
                final var perimeter = Double.parseDouble(scanner.next());

                System.out.printf("Caso de teste Paralelogramo #%d ", caseNumber++);
                Assertions.assertTrue(Paralelogramo.existe(p1, p2, p3, p4),
                    "Teste de existencia do paralelogramo falhou para pontos validos: "
                        + Arrays.toString(new Ponto[]{p1, p2, p3, p4}));
                Assertions.assertEquals(width, parallelogram.largura(), delta,
                    "Largura do paralelogramo fora do esperado. " + parallelogram);
                Assertions.assertEquals(height, parallelogram.altura(), delta,
                    "Altura do paralelogramo fora do esperado. " + parallelogram);
                Assertions.assertEquals(area, parallelogram.area(), delta,
                    "Area do paralelogramo fora do esperado. " + parallelogram);
                Assertions.assertEquals(perimeter, parallelogram.perimetro(), delta,
                    "Perimetro do paralelogramo fora do esperado. " + parallelogram);

                System.out.println("OK");
            }

            // negative existence tests
            Ponto[][] falseShapes = {
                {
                    new Ponto(0.1, 0.25),
                    new Ponto(0.7, 0.25),
                    new Ponto(0.6, 0.0),
                    new Ponto(0.4, 0.0)
                },
                {
                    new Ponto(0.2, 0.6),
                    new Ponto(0.1, 0.5),
                    new Ponto(0.9, 0.2),
                    new Ponto(0.3, 0.4)
                },
                {
                    new Ponto(0.2, 0.6),
                    new Ponto(0.1, 0.5),
                    new Ponto(0.4, 0.45),
                    new Ponto(0.3, 0.4)
                }
            };

            for (var points : falseShapes) {
                System.out.printf("Caso de teste Paralelogramo #%d ", caseNumber++);
                Assertions.assertFalse(Paralelogramo.existe(
                    points[0], points[1], points[2], points[3]),
                    "Falso positivo ao aplicar teste de existencia de paralelogramo "
                        + Arrays.toString(points));
                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Falha ao abrir o arquivo de casos de paralelogramos");
            e.printStackTrace();
        }
    }

    @Test
    public void testRectangles() {
        String[] files = new String[]{rectanglesFile, squaresFile};
        var caseNumber = 1;

        for (var file : files) {
            var testSuite = file.equals(rectanglesFile) ? "Retangulo" : "Quadrado";
            try (var scanner = new Scanner(new File(file))) {
                while (scanner.hasNext()) {
                    final var p1 = new Ponto(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    final var p2 = new Ponto(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    final var p3 = new Ponto(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    final var p4 = new Ponto(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    final var rectangle = new Retangulo(p1, p2, p3, p4);
                    final var width = Double.parseDouble(scanner.next());
                    final var height = Double.parseDouble(scanner.next());
                    final var area = Double.parseDouble(scanner.next());
                    final var perimeter = Double.parseDouble(scanner.next());
                    final var isSquare = Boolean.parseBoolean(scanner.next());

                    System.out.printf("Caso de teste %s #%d ", testSuite, caseNumber++);
                    Assertions.assertTrue(Retangulo.existe(p1, p2, p3, p4),
                        "Falso negativo para teste de existencia de retangulo: "
                            + Arrays.toString(new Ponto[]{p1, p2, p3, p4}));
                    Assertions.assertEquals(width, rectangle.largura(), delta,
                        "Largura do retangulo fora do esperado. " + rectangle);
                    Assertions.assertEquals(height, rectangle.altura(), delta,
                        "Altura do retangulo fora do esperado. " + rectangle);
                    Assertions.assertEquals(area, rectangle.area(), delta,
                        "Area do retangulo fora do esperado." + rectangle);
                    Assertions.assertEquals(perimeter, rectangle.perimetro(), delta,
                        "Perimetro do retangulo fora do esperado." + rectangle);
                    Assertions.assertEquals(isSquare, rectangle.quadrado(),
                        "Teste de quadrado para retangulo falhou. " + rectangle);

                    System.out.println("OK");
                }
            } catch (FileNotFoundException e) {
                System.err.println("Falha ao abrir arquivos de casos para retangulos");
                e.printStackTrace();
            }

            // negative existence tests
            Ponto[][] falseShapes = {
                {
                    new Ponto(0.1, 0.25),
                    new Ponto(0.7, 0.25),
                    new Ponto(0.6, 0.0),
                    new Ponto(0.4, 0.0)
                },
                {
                    new Ponto(0.2, 0.6),
                    new Ponto(0.1, 0.5),
                    new Ponto(0.9, 0.2),
                    new Ponto(0.3, 0.4)
                },
                {
                    new Ponto(0.2, 0.6),
                    new Ponto(0.1, 0.5),
                    new Ponto(0.4, 0.45),
                    new Ponto(0.3, 0.4)
                },
                {
                    new Ponto(0.2, 0.2),
                    new Ponto(0.8, 0.2),
                    new Ponto(0.6, 0.5),
                    new Ponto(0.0, 0.0)
                }
            };

            for (var points : falseShapes) {
                System.out.printf("Caso de teste Retangulo #%d ", caseNumber++);
                Assertions.assertFalse(Retangulo.existe(
                    points[0], points[1], points[2], points[3]),
                    "Falso positivo para teste de existencia de retangulo: "
                        + Arrays.toString(points));
                System.out.println("OK");
            }
        }
    }

    @Test
    public void testTriangles() {
        try (var scanner = new Scanner(new File(trianglesFile))) {
            var caseNumber = 1;

            while (scanner.hasNext()) {
                final var p1 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p2 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var p3 = new Ponto(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                final var triangulo = new Triangulo(p1, p2, p3);
                final var width = Double.parseDouble(scanner.next());
                final var height = Double.parseDouble(scanner.next());
                final var area = Double.parseDouble(scanner.next());
                final var perimeter = Double.parseDouble(scanner.next());

                System.out.printf("Caso de teste Triangulo #%d ", caseNumber++);
                Assertions.assertEquals(width, triangulo.largura(), delta,
                    "Largura do triangulo fora do esperado. " + triangulo);
                Assertions.assertEquals(height, triangulo.altura(), delta,
                    "Altura do triangulo fora do esperado. " + triangulo);
                Assertions.assertEquals(area, triangulo.area(), delta,
                    "Area do triangulo fora do esperado." + triangulo);
                Assertions.assertEquals(perimeter, triangulo.perimetro(), delta,
                    "Perimetro do triangulo fora do esperado." + triangulo);
                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Falha ao abrir arquivo de casos de triangulos");
            e.printStackTrace();
        }
    }

}
