import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class LosSaltosDeMario {

    static StringBuilder sb = new StringBuilder();
    static final String salto = "\n";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        while (casos > 0) {
            int tamaño = sc.nextInt();
            int sube = 0;
            int baja = 0;
            int[] array = new int[tamaño];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    baja++;
                } else if (array[i] < array[i + 1]) {
                    sube++;
                }
            }
            sb.append(sube).append(" ").append(baja).append(salto);
            casos--;
        }
        System.out.print(sb);
    }

}