import java.util.Scanner;

/**
 *
 * @author Jose Daniel Organist
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int c = r.nextInt();
        int vo = r.nextInt();
        int v1 = r.nextInt();
        int a = r.nextInt();
        int l = r.nextInt();
        int al = 0;
        int leidas = 0;
        int dias = 0;
        boolean b = false;
        while (!b) {    
            al = vo + dias * a;
            if (al < v1) {
                leidas = leidas + al;
            } else {
                leidas = leidas + v1;
            }
            if (leidas >= c) {
                b=true;
            }else{
                leidas = leidas - l;
            }
            dias++;
        }
        System.out.println(dias);
    }
    
}