import java.util.Scanner;

public class Elections {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if(a > max ) max = a;
            sum += a;
        }
        int k = max;
        while(n*k<=2*sum) k++;
        System.out.println(k);
    }
}