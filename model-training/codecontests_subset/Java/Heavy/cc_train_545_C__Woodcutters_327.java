import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int X = 0;
        final int H = 1;

        final int L = 0;
        final int M = 1;
        final int R = 2;

        int n = scan.nextInt();
        int[][] data = new int[n][2];

        for(int i=0; i<n; i++){
            int x = scan.nextInt();
            int h = scan.nextInt();
            data[i][X] = x;
            data[i][H] = h;
        }

        long count = 0;
        for(int i=0; i<n; i++){
            if(i == 0 || i == n-1) {
                count++;
                continue;
            }

            int x = data[i][X];
            int h = data[i][H];

            if(data[i-1][X] < x-h) {
                count++;
            }
            else if(x+h < data[i+1][X]) {
                data[i][X] = x+h;
                count++;
            }
        }
        System.out.println(count);
    }
}