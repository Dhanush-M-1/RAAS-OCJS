import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int[] c = new int[m];
        int[] d = new int[m];

        for(int i = 0; i < m; i++){
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < m; j++) {
                int tmp = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);

                min = Math.min(min, tmp);
            }

            for(int j = 0; j < m; j++){
                if(min == Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j])){
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}
