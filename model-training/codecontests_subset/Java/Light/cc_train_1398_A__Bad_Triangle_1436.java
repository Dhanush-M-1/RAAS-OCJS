import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int t, n, k;
        Scanner cin = new Scanner(System.in);
        t = cin.nextInt();
        while(t > 0){
            n = cin.nextInt();
            int []ar = new int[n];
            for(int i = 0; i<n; i++){
                ar[i] = cin.nextInt();
            }
            if(ar[0] + ar[1] <=ar[n-1]) System.out.println("1 2 " + n);
            else System.out.println(-1);
            t--;
        }

    }
}
