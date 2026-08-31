import java.util.*;

public class Main {

    private static int N;
    private static int[][][] F;
    private static int[][] P;

    public static void inputNFP() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = new int[N][5][2];
        P = new int[N][11];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 2; k++) {
                    F[i][j][k] = sc.nextInt();
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 11; j++) {
                P[i][j] = sc.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        inputNFP();
        int max = -1 * Integer.MIN_VALUE;
        int[] M = new int[10];
        for (int dec = 1; dec < 1024; dec++) {
            String binary = Integer.toBinaryString(dec);
            int bin = Integer.parseInt(binary);
            for (int i = 9; i >= 0; i--) {
                M[i] = bin % 10;
                bin /= 10;
            }
            int profits = 0;
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < 10; j++) {
                    if(M[j] == 1 && F[i][j/2][j%2] == 1) {
                        count++;
                    }
                }
                profits += P[i][count];
            }
            max = Math.max(max, profits);
        }
        System.out.println(max);
    }

}
