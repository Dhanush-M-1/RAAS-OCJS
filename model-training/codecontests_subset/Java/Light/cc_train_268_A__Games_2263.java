import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Games {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> H = new ArrayList<>();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            int h = sc.nextInt();
            int a = sc.nextInt();
            H.add(h);
            A.add(a);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (H.get(i).equals(A.get(j)))
                    ans++;
            }
        }
        System.out.println(ans);
    }
}