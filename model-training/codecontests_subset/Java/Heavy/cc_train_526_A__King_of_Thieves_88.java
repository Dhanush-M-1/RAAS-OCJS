
import java.util.Scanner;
import oracle.jrockit.jfr.events.Bits;

public class ZepA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int[] zv = new int[n];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                zv[i] = 1;
            }
            else {
                zv[i] = 0;                        
            }
        }
        for (int i = 0; i < n; i++) {
            if (zv[i] == 0) continue;
            for (int j = 1; j*4 + i < n; j++) {
                boolean ura = true;
                for (int k = 1; k <= 4; k++) {
                    if ((zv[i+ j*k] != 1)) {
                        ura = false;
                    }                    
                }
                if (ura) {
                    System.out.println("yes");
                    return;
                }
            }
            
        }
        System.out.println("no");
        
        
    }
    
}
