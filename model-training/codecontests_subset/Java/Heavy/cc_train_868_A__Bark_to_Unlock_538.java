import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String pass = in.next();
        char lOfPass = pass.charAt(0);
        char rOfPass = pass.charAt(1);
        int n = in.nextInt();
        char r = 0, l = 0;
        String cur = null;
        boolean ok = false;
        
        for(int i = 0; i < n; i ++) {
            cur = in.next();
            if(cur.equals(pass)) {
                ok = !ok;
            }
            if(cur.charAt(0) == rOfPass) {
                l = cur.charAt(0);
            }
            if(cur.charAt(1) == lOfPass) {
                r = cur.charAt(1);
            }
        }

        if((r == lOfPass && l == rOfPass) || ok) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
