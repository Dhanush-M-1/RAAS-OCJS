import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Askar on 19.06.2017.a
 */

public class task1 {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer> mas = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int q = in.nextInt();
            for (int j = 0; j < q; j++)
                mas.add(in.nextInt());
        }

        Collections.sort(mas);
        int c = 1;
        if (mas.isEmpty()==true)System.out.println("NO");
        else if (mas.get(mas.size() - 1) == 0) System.out.println("NO");
        else {
            for (int i = 1; i < mas.size(); i++) {
                if (mas.get(i) - mas.get(i - 1) == 1) c++;
                else if (mas.get(i) - mas.get(i - 1) == 0) ;
                else break;
            }

            if (c == m) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}