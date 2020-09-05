import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Fernando
 */
public class PistasDeAterrizaje {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int numero;
    static String pista, num;
    static char letra;
    final static String SaltoDeLinea = "\n";

    public static void main(String[] args) throws IOException {
        while ((pista = in.readLine()) != null) {
            letra = ' ';
            if (pista.length() == 2) {
                numero = Integer.parseInt(pista);
            } else {
                letra = pista.charAt(2);
                numero = Integer.parseInt(pista.substring(0, 2));
            }
            if (numero <= 18) {
                numero = 18 + numero;
            } else {
                numero = numero - 18;
            }
            num = String.valueOf(numero);
            if (numero <= 9) {
                num = "0" + numero;
            }
            if (letra != ' ') {
                if (letra == 'L') {
                    letra = 'R';
                } else if (letra == 'R') {
                    letra = 'L';
                }
                num = num + letra;
            }
            sb.append(num).append(SaltoDeLinea);
            System.out.println(num);
        }
        System.out.print(sb.toString());
    }
}
