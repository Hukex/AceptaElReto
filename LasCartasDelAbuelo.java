import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class LasCartasDelAbuelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos;
        int[] B = new int[1000009];
        boolean hola = true;
        while (hola) {
            String cadena = sc.nextLine();
            for (int i = 1; i < cadena.length(); i++) {
                B[i] = cadena.charAt(i) == cadena.charAt(i - 1) ? B[i - 1] : i;
            }
            casos = sc.nextInt();
            hola = true;
            if (casos == 0) {
                hola = false;
            }
            if (hola) {
                while (casos-- > 0) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    if (l > r) {
                        System.out.println(B[l] <= r ? "SI" : "NO");
                    } else {
                        System.out.println(B[r] <= l ? "SI" : "NO");
                    }
                }
                System.out.println("");
                sc.nextLine();
            }
        }

    }
}