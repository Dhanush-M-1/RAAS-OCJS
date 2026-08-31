import java.util.*;

public class BearAndRaspberry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] price = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++)
            price[i] = in.nextInt();
        for (int j = 1; j < n; j++) {
            if ((price[j - 1] - price[j]) > max)
                max = price[j - 1] - price[j];
        }
        max = max - c;
        if (max > 0)
            System.out.println(max);
        else
            System.out.println("0");
        in.close();
    }
}