import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] F = new int[n][10];
        int[][] P = new int[n][11];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<10; j++) {
                F[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<11; j++) {
                P[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i<Math.pow(2,10); i++) {
            int num = i;
            int[] cnt = new int[n];
            int index = 0;
            while(index < 10) {
                int isOpen = num%2;
                for(int j = 0; j<n; j++) {
                    if(F[j][index] == 1 && isOpen == 1) cnt[j]++;
                }
                num /= 2;
                index++;
            }
            int total = 0;
            for(int j = 0; j<n; j++) {
                total += P[j][cnt[j]];
            }
            max = Math.max(max, total);
        }
        System.out.println(max);
    }
}