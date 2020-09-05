import java.io.IOException;

/**
 *
 * @author Fernando
 */
public class PanicoEnElTunel {

    static StringBuilder sb = new StringBuilder();
    static String Salto = "\n";

    public static int leerNumero() throws IOException {
        char c = (char) System.in.read();
        String cadenaNumero = "";
        while (c != '\n') {
            cadenaNumero = cadenaNumero + c;
            c = (char) System.in.read();
        }
        return Integer.valueOf(cadenaNumero);
    }

    public static void main(String[] args) throws IOException {
        int x = System.in.read();
        char sec = (char) x;
        while (x != -1) {
            boolean seguirAQUI;
            int posicionAnterior;
            int posicionPosterior;
            int[] tunel = new int[510];
            int h = 0;
            int tamanhoReal = 1;
            while (sec != '\n') {
                if (sec == 'T') {
                    tunel[h] = tamanhoReal;
                    h++;
                }
                tamanhoReal++;
                sec = ((char) System.in.read());
            }
            int consultas = leerNumero();
            while (consultas-- > 0) {
                posicionAnterior = 0;
                seguirAQUI = true;
                int lugar = leerNumero();
                for (int i = 0; i < h && seguirAQUI; i++) {
                    if (tunel[i] == lugar) {
                        seguirAQUI = false;
                    }
                }
                if (seguirAQUI == false) {
                    sb.append("AQUI").append(Salto);
                } else {
                    for (int i = 0; i < h; i++) {
                        if (tunel[i] < lugar) {
                            posicionAnterior = tunel[i];
                        }
                    }
                    posicionPosterior = tamanhoReal;
                    for (int i = h; i >= 0; i--) {
                        if (tunel[i] > lugar) {
                            posicionPosterior = tunel[i];
                        }
                    }
                    posicionAnterior = Math.abs(posicionAnterior - lugar);
                    posicionPosterior = Math.abs(posicionPosterior - lugar);
                    if (posicionAnterior > posicionPosterior) {
                        sb.append("ISLAS").append(Salto);
                    } else if (posicionAnterior == posicionPosterior) {
                        if (Math.abs(tamanhoReal - lugar) >= lugar) {
                            sb.append("PENINSULA").append(Salto);
                        } else {
                            sb.append("ISLAS").append(Salto);
                        }
                    } else {
                        sb.append("PENINSULA").append(Salto);
                    }
                }
            }
            x = System.in.read();
            if (x != -1) {
                sec = (char) x;
            }
        }
        System.out.print(sb);
    }
}