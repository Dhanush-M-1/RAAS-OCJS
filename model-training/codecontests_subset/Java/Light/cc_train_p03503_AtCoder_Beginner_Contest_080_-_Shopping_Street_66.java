import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] storeArray = new int[n];
        for (int i = 0 ; i < n ; i++ ) {
            int storePtn = 0;
            int multi = 1;
            for (int j = 0 ; j < 10 ; j++ ) {
                int f = sc.nextInt();
                storePtn += f * multi;
                multi *= 2;
            }
            storeArray[i] = storePtn;
        }

        int[][] p = new int [n][11];
        for (int i = 0 ; i < n ; i++ ) {
            for (int j = 0 ; j <= 10 ; j++ ) {
                p[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1 ; i <= 1023 ; i++) {
            int temp = 0;
            for (int j = 0 ; j < n ; j++ ) {
                temp += p[j][openStoreNumberAtTheSameTime(i, storeArray[j])];
            }
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }

    static int openStoreNumberAtTheSameTime (int i , int j) {
        int multiple = i & j;
        int count = 0;
        while (multiple > 0 ) {
            count += multiple % 2;
            multiple /= 2;
        }
        return count;
    }

}