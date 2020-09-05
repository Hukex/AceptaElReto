import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class Ascensor {

    static StringBuilder sb = new StringBuilder();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numInicial;
        int numSiguiente;
        int numPrueba;
        int suma;
        while ((numInicial = sc.nextInt()) >= 0) {
            numSiguiente = 0;
            suma = 0;
            numPrueba = numInicial;
            while (numSiguiente != -1) {
                numSiguiente = sc.nextInt();
                if (numSiguiente != -1) {
                    suma = suma + Math.abs(numPrueba - numSiguiente);
                    numPrueba = sc.nextInt();
                    suma = suma + Math.abs(numPrueba - numSiguiente);
                }
            }
            sb.append(suma).append("\n");
        }
        System.out.print(sb);

    }
}
