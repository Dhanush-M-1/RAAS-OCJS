import java.util.Arrays;
import java.io.*;
import java.util.*;

public class Main {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            long sum = 0;
            int max = 0;
            for (int i = 0; i < n; ++i) {
                int temp = sc.nextInt();
                if(max<temp){
                    max=temp;
                }
                sum += temp;
            }
            n--;
            if (sum % n != 0)
                sum = sum / n + 1;
            else
                sum /= n;
            System.out.println(Math.max(sum,max));
        }
    }
}
