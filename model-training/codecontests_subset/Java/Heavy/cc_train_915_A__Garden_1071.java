
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 *
 * @author rn-sshawish
 */
public class Contest915A {
    public static void main(String[] args)throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokn = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokn.nextToken());
        int m = Integer.parseInt(tokn.nextToken());
        int [] data = new int[n];
        tokn = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(tokn.nextToken());
        }
        Arrays.sort(data);
        for (int i = data.length - 1; i > -1; i--) {
            if (m % data[i] == 0 ) {
                System.out.println(m / data[i]);
                break;
            }
        }
        
    }
}
