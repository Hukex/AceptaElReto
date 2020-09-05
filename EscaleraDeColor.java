import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class EscaleraDeColor {

    static StringBuilder sb = new StringBuilder();
    final static String SaltoDeLinea = "\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] fila = new char[15];
        boolean seguir = true;
        boolean seguirnumeros = true;
        char pieza;
        while ((pieza = sc.next().charAt(0)) != '0') {
            for (int i = 0, j = 1; j < fila.length; i = i + 2, j = j + 2) {
                fila[i] = pieza;
                fila[j] = ' ';
                pieza = sc.next().charAt(0);
            }
            fila[14] = pieza;
            int[] numeros = new int[4];
            for (int i = 0, j = 0; i < numeros.length; i++, j = j + 4) {
                switch (fila[j]) {
                    case 'J':
                        numeros[i] = 11;
                        break;
                    case 'Q':
                        numeros[i] = 12;
                        break;
                    case 'K':
                        numeros[i] = 13;
                        break;
                    case 'A':
                        numeros[i] = 14;
                        break;
                    default:
                        numeros[i] = fila[j] - 48;
                        break;
                }
                if (numeros[i] == 1) {
                    numeros[i] = 10;
                }
            }
            char letracomparar = fila[2];
            char[] letras = new char[4];
            for (int i = 0, j = 2; i < letras.length && seguir; i++, j = j + 4) {
                letras[i] = fila[j];
                if (letras[i] != letracomparar) {
                    seguir = false;
                }
            }
            Arrays.sort(numeros);
            for (int i = 0; i < numeros.length - 1 && seguirnumeros && seguir; i++) {
                if ((numeros[i] + 1) != numeros[i + 1]) {
                    seguirnumeros = false;
                }
            }
            int lugar = 0;
            boolean prueba = true;
            if (seguirnumeros == false) {
                for (int i = 0; i < numeros.length - 1 && prueba; i++) {
                    if ((numeros[i] + 1) != numeros[i + 1]) {
                        if ((numeros[i] + 2) == numeros[i + 1]) {
                            prueba = false;
                            lugar = i;
                        }
                    }
                }
                int[] numerosfinales = new int[5];
                for (int i = 0; i < numeros.length; i++) {
                    numerosfinales[i] = numeros[i];
                }
                numerosfinales[4] = numeros[lugar] + 1;
                Arrays.sort(numerosfinales);
                for (int i = 0; i < numerosfinales.length - 1 && seguir; i++) {
                    if ((numerosfinales[i] + 1) != numerosfinales[i + 1]) {
                        seguir = false;
                    }
                }
            }
            if (seguir == false) {
                sb.append("NADA").append(SaltoDeLinea);
            } else {
                int siguientenumcarta;
                char letracarta = ' ';
                if (lugar == 0 && numeros[3] != 14) {
                    lugar = 3;
                }
                if (numeros[3] == 14) {
                    siguientenumcarta = numeros[lugar] - 1;
                } else {
                    siguientenumcarta = numeros[lugar] + 1;
                }
                switch (siguientenumcarta) {
                    case 11:
                        letracarta = 'J';
                        break;
                    case 12:
                        letracarta = 'Q';
                        break;
                    case 13:
                        letracarta = 'K';
                        break;
                    case 14:
                        letracarta = 'A';
                        break;
                    default:
                        break;
                }
                if (letracarta == ' ') {
                    sb.append(siguientenumcarta).append(" ").append(letracomparar).append(SaltoDeLinea);
                } else {
                    sb.append(letracarta).append(" ").append(letracomparar).append(SaltoDeLinea);
                }
            }
            seguir = true;
            seguirnumeros = true;
        }
        System.out.print(sb.toString());
    }
}