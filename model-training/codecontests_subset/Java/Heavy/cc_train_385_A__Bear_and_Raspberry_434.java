
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author tino chagua
 */
public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cad = br.readLine().split(" ");
        int n = Integer.valueOf(cad[0]);
        int c = Integer.valueOf(cad[1]);
        int[] price = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            price[i] = Integer.valueOf(str[i]) - Integer.valueOf(str[i + 1]);
        }
        Arrays.sort(price);
        if (price[n - 1] - c < 0) {
            System.out.println(0);
        } else {
            System.out.println(price[n - 1] - c);
        }//show(price);
    }

    static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}