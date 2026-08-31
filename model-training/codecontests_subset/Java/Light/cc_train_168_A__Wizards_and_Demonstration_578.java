import com.sun.source.tree.Tree;

import java.util.*;

public class Pair {


    public static void main(String[] args) throws Exception {

        try {
            Scanner scanner = new Scanner(System.in);
            short n = scanner.nextShort();
            short w = scanner.nextShort();
            short p = scanner.nextShort();
            int r = (int)(Math.ceil(((p*n)/100.0)));
            System.out.println(r > w ? r - w : 0);
            scanner.close();

         }
        catch (Exception e) {
        }
    }
}
