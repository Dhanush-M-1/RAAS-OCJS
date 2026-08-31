import java.util.ArrayList;
import java.util.Scanner;

public class Bulbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= m; i++)
            arr.add(i);
        for (int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            for (int j = 0; j < x; j++)
            {
                int y = sc.nextInt();
                arr.remove((Integer)y);
            }
        }
        System.out.println(arr.isEmpty()?"YES":"NO");
    }
}
