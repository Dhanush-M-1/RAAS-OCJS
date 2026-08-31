import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: AUtemuratov
 * Date: 07.04.14
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class ValeraX {

    static int n,x,sum,max=-111111111;
    static int a[] = new int[111];
    static int b[] = new int[111];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(tk.nextToken());
        x = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(bf.readLine(), " ");

        for (int i=1; i<=n; i++){
            a[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i=1; i<n; i++) {
            sum = a[i]-a[i+1]-x;
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }
        if (max<0) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }
    }
}
