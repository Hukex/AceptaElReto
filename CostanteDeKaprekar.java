import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class ConstanteDeKaprekar{

    static StringBuilder sb = new StringBuilder();
    final static String Salto = "\n";
    static int[] numero = new int[4], numeroalreves = new int[4];
    static int contador, num1, num2;
    static char[] numeroarray = new char[4];
    static boolean costante = true, seguir = true, hola = true;
    static String numerostring, numerostringalreves,ceros = "0";
   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine();
        while (casos > 0) {
            contador = 1;
            seguir = true;
            numerostring = sc.nextLine();
            if (numerostring.equalsIgnoreCase("6174")) {
                sb.append("0").append(Salto);
            }
            else if(numerostring.equalsIgnoreCase("0")){
                sb.append("8").append(Salto);
            }
                else {
                hola = true;
                while (seguir) {
                    if (hola) {
                        while (numerostring.length()<4){
                            numerostring = numerostring+ceros;
                        }
                        numeroarray = numerostring.toCharArray();
                        for (int i = 0; i < numero.length; i++) {
                            numero[i] = (numeroarray[i] - 48);
                        }
                        hola = false;
                    } else {

                        String numerofinal = String.valueOf(num2);
                        char[] jol = numerofinal.toCharArray();
                        for (int i = 0; i < jol.length; i++) {
                            numero[i] = (jol[i] - 48);
                        }
                        if (jol.length == 3) {
                            numero[3] = 0;
                        }
                    }
                    Arrays.sort(numero);
                    numerostringalreves = "";
                    for (int i = 0, j = numero.length - 1; i < numero.length; i++, j--) {
                        numeroalreves[i] = numero[j];
                        numerostringalreves = numerostringalreves + numeroalreves[i];
                    }
                    numerostring = "";
                    for (int i = 0; i < numero.length; i++) {
                        numerostring = numerostring + numero[i];
                    }

                    num1 = Integer.parseInt(numerostring);
                    num2 = Integer.parseInt(numerostringalreves);
                    num2 = num2 - num1;
                    if (num2 < 0) {
                        num2 = num2 * -1;
                    }
                    if (num2 == 6174) {
                        seguir = false;
                        sb.append(contador).append(Salto);
                    } else if (num1 == 1111 || num1 == 2222 || num1 == 3333 || num1 == 4444 || num1 == 5555 || num1 == 6666 || num1 == 7777 || num1 == 8888 || num1 == 9999 || num1 == 0000) {
                        sb.append("8").append(Salto);
                        seguir = false;
                    }
                    contador++;
                }

            }
            casos--;
        }
        System.out.print(sb.toString());
    }
}