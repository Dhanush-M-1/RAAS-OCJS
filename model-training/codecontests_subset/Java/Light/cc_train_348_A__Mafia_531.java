import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by KC on 4/4/14.
 */
public class Mafia {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] p = bufferedReader.readLine().trim().split("\\s+");
        long sum = 0;
        long max = 0;
        for(int i = 0; i < n; i++){
            long pt = Long.parseLong(p[i]);
            max = Math.max(max,pt);
            sum += pt;
        }

        long round = (sum)/(n-1);
        if( (sum)%(n-1) >0 ) round++;
        round = round > max ? round : max;
        System.out.println(round);






    }
}
