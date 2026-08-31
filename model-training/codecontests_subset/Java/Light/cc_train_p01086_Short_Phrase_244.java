import java.util.Scanner;

public class Main {
    static int[] sp = {5,7,5,7,7};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if(n==0) break;
            int[] w = new int[n];

            for (int i = 0; i < n; i++) {
                w[i] = sc.next().length();
            }

            int j = 0, k = 0, s = 0;
            for (int i = 0; i < n; i++) {
                k += w[i];
                if (k==sp[j]){
                    j++;
                    if (j==5) break;
                    k = 0;
                }else if (k>sp[j]){
                    j = 0;
                    i = s++;
                    k = 0;
                }
            }

            System.out.println(s+1);
        }
    }
}