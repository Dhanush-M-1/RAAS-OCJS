import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[m];
        int[] d = new int[m];
        for(int i = 0;i < n + m;i++) {
            if(i < n) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            else {
                c[i - n] = sc.nextInt();
                d[i - n] = sc.nextInt();
            }
        }
        
        for(int i = 0;i < n;i++) {
            int min = Integer.MAX_VALUE;
            int num = -1;
            for(int j = 0;j < m;j++) {
                int distance = Math.abs(c[j] - a[i]) + Math.abs(d[j] - b[i]);
                if(min > distance) {
                    num = j;
                    min = distance;
                }
            }
            System.out.println(num + 1);
        }
        
    }
}
