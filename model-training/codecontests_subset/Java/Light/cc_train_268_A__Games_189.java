import java.util.*;
public class CF268A {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] h = new int[n];
        int[] a = new int[n];
        int counter = 0;
        for(int i = 0; i < n; i++)
        {
            h[i] = input.nextInt();
            a[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(h[i] == a[j])
                    counter++;
        System.out.println(counter);
    }
}
