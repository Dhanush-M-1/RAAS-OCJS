import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Labb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Set<String> str = new HashSet<>();

        String x = s.next();
        String y = s.next();
        int n = s.nextInt();
        String res = x + " " + y + "\n";
        str.add(x);
        str.add(y);
        for (int i = 0; i < n; i++) {
            x = s.next();
            y = s.next();
            str.remove(x);
            str.add(y);
            res += str.toArray()[0] + " " + str.toArray()[1] + "\n";
        }
        System.out.println(res.trim());
    }

}