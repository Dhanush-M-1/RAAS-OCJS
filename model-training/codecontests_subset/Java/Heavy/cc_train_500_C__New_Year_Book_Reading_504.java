import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: <br />
 * Date: 2014/12/30 23:00<br />
 * Description:<br />
 *
 * @author sjtudesigner
 */
public class ProblemC {

    private static ArrayList<Integer> al = new ArrayList<Integer>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] book = new int[n];
        int[] day = new int[m];

        for (int i = 0;i < n;i++)
            book[i] = sc.nextInt();
        for (int i = 0;i < m;i++)
        {
            day[i] = sc.nextInt();
            al.add(day[i]);
        }

        boolean[] helper = new boolean[n];
        boolean[] del = new boolean[m];
        for (int i = 0;i < m;i++)
        {
            if (!helper[al.get(i) - 1]) helper[al.get(i) - 1] = true;
            else del[i] = true;
        }
        for (int i = m - 1;i >= 0;i--)
        {
            if (del[i])
                al.remove(i);
        }

        int res = 0;
        for (int i = 0;i < m;i++)
        {
            int get = day[i];
            int idx = al.indexOf(get);
            for (int j = 0;j < idx;j++) res += book[al.get(j) - 1];
            al.remove(idx);
            al.add(0, get);
        }
        System.out.println(res);
    }
}
