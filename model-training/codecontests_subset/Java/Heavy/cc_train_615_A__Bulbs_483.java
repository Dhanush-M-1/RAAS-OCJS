import java.util.*;

/**
 *
 * @author user
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            for (int j = 0; j < x; j++) {
                int f = s.nextInt();
                hmap.put(f, i);
            }
        }

        if (hmap.size() == m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
