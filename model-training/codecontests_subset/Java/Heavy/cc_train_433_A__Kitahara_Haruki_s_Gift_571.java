import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Machis
 */
public class KitaharaHarukisGift {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int res = 0;
        int[] w = new int[2];
        for (int i = 0; i < n; i++) {
            int wt = Integer.parseInt(st.nextToken());
            if (wt == 100) {
                w[0]++;
            } else {
                w[1]++;
            }
            res += wt;
        }
        if (w[0] % 2 == 0 && w[1]%2 == 0) {

            System.out.println("YES");
        } else {
            if (w[0]%2==0 && w[0]!=0){
                  System.out.println("YES");
            }
            else
            System.out.println("NO");
        }

    }

}