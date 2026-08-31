import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 1   1   1
 * 2 5 4 0 4
 * 3
 * 
 * 
 * 
 * */
public class AInitialBet {
    public static void main(String[]arg) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[]arr = new int[5];
        int total  = 0;
        for(int i = 0; i < 5; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        if(total%5 ==0 && total != 0)
            System.out.println(total/5);
        else
            System.out.println(-1);
    }
}
