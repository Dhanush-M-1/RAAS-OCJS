import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        int[] ascii = new int[200];
        boolean[] mark = new boolean[200];
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int k = l.nextInt();
        String s = l.next();
        boolean ok = true;
        for (int i = 0; i < s.length(); i++) {
            int as = s.charAt(i);
            if (!mark[as]) {
                lista.add(as);
                mark[as] = true;
            }
            ascii[as]++;
           
        }
       
            for (int i = 0; i < lista.size(); i++) {
                int integer = lista.get(i);
                if (ascii[integer] % k != 0) {
                    ok = false;
                    break;
                }
            }
        
        if (ok) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < lista.size(); j++) {
                    int integer = lista.get(j);
                    for (int m = 0; m < ascii[integer]/k; m++) {

                        System.out.print(((char)integer));
                    }
                    
                }
            }
            System.out.println("");
        } else {
            System.out.println("-1");
        }
    }
}
