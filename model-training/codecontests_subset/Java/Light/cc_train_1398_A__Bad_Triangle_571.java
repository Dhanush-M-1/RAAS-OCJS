import java.util.*;
public class ECR_92_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i]=sc.nextInt();
            System.out.println(a[0]+a[1]<=a[n-1]?"1 2 "+n:"-1");
        }
    }
}