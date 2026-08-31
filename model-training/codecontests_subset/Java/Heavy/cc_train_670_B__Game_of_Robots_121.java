import java.util.ArrayList;
import java.util.Scanner;

public class codeforce670B {

    static Scanner in = new Scanner(System.in);

    public static void main (String[]args) {

        int n = in.nextInt();
        long k = in.nextLong();
        int[] mas = new int[n];
        long left = 0;
        int right = 1;
        int index = -1;
        long sum = 0;
        for (int i = 0; i <n ; i++) {
            mas[i] = in.nextInt();
        }

        while (sum<k){
            left = sum;
            sum += right;
            right++;
            index++;
        }
        index--;
        for (long i = left; i <= sum; i++) {
            if (i==k)
                break;
            if (i==left)
                index = 0;
            else if (index==n-1){
                index = 0;
            } else {
                index++;
            }
        }
        System.out.print(mas[index]);
    }

}
