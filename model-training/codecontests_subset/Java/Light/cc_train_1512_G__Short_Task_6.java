import java.util.Scanner;

public class P{
    public static void main(String[] args) {
        int lim = 10000005;
        int[] d = new int[lim];
        int[] e = new int[lim];
        for(int i = 1; i < lim; i++) {
            for(int j = i; j < lim; j += i) {
                d[j] += i;
            }
            if(d[i] < lim && e[d[i]] == 0) {
                e[d[i]] = i;
            }

        }

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            int c = scan.nextInt();
            int val = e[c];
            if(val != 0) System.out.println(val);
            else System.out.println(-1);
        }
        scan.close();
    }
}