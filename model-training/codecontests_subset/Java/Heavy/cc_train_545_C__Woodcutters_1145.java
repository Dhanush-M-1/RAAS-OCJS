import java.util.Scanner;

public class Main {
    public static int n;
    public static void main(String[] args) {

        int[][] trees;
        int[][] din;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        trees = new int[2][n];
        din = new  int[2][n];
        for (int number = 0; number<n; number++){
            trees[0][number] = sc.nextInt();
            trees[1][number] = sc.nextInt();
        }
        din[0][0] = 1;
        din[1][0] = trees[0][0];
        for (int i = 1; i < n - 1; i++)
        {
            if (trees[0][i] - trees[1][i] > din[1][i-1])
            {
                din[0][i] = din[0][i - 1] + 1;
                din[1][i] = trees[0][i];
            }
            else
            {
                if (trees[0][i] + trees[1][i] < trees[0][i + 1])
                {
                    din[0][i] = din[0][i - 1] + 1;
                    din[1][i] = trees[0][i] + trees[1][i];
                }
                else
                {
                    din[0][i] = din[0][i - 1];
                    din[1][i] = trees[0][i];
                }

            }

        }
        if (n == 1)
            System.out.println(1);
        else
            System.out.println(din[0][n-2] + 1);
    }
}
