
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * @author Mx
 * Dec 28, 2013 10:42:28 AM
 */

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        int minimumP = (int)Math.ceil(n*(y / 100.0));
        if(minimumP-x > 0 ){
            System.out.println(minimumP-x);
        } else {
            System.out.println(0);
        }
    }
}
