import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] errors1 = new int[n];
        int[] errors2 = new int[n - 1];
        int[] errors3 = new int[n - 2];

        for (int i = 0; i < errors1.length; i++) {
            errors1[i] = sc.nextInt();
        }

        for (int i = 0; i < errors2.length; i++) {
            errors2[i] = sc.nextInt();
        }

        for (int i = 0; i < errors3.length; i++) {
            errors3[i] = sc.nextInt();
        }

        long[] result = findError(n, errors1, errors2, errors3);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    //cpu O(n)
    //mem O(1)
    public static long[] findError(int n, int[] errors1, int[] errors2, int[] errors3) {

        int allErrors[][] = {errors1, errors2, errors3};
        long out[] = new long[2];
        int sum1 = 0;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < allErrors[i].length; j++) {
                sum += allErrors[i][j];
            }
            int ans=sum1 - sum;
            sum1 = sum;
            if (i>=1){
                out[i - 1] = ans;

            }

        }
        return out;
    }
}