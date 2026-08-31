import java.util.Scanner;

/**
 * Created by Rukshar Alam on 3/30/2017.
 */
public class Games268A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h[] = new int[n];
        int a[] = new int[n];

        for(int i = 0;i<n;i++)
        {
            h[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }

        int count = 0;

        for(int i =0;i<n-1;i++)
        {
            int first = h[i];
            for(int j = i+1;j<n;j++)
            {
                if(a[j] == first)
                {
                    count++;
                }

            }

            int second = a[i];
            for(int j = i+1;j<n;j++)
            {
                if(h[j] == second)
                {
                    count++;
                }

            }

        }

        System.out.println(count);
    }
}
