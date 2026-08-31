
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by naveen on 19-Dec-15.
 */
public class test {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int ln = scn.nextInt();

            for (int j = 0; j < ln; j++) {
                numSet.add(scn.nextInt());
            }
        }

        if(numSet.size() == m)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
