import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * @author Bassem Ehab
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Apples = Integer.parseInt(br.readLine());
        int sum1 = 0;
        int sum2 = 0;
        StringTokenizer Gram = new StringTokenizer(br.readLine());
        for (int i = 0; i < Apples; i++) {
            int x=Integer.parseInt(Gram.nextToken());
            if(x==100)sum1++;
            else if(x==200)sum2++;
        }
        if(sum1!=0&&sum1%2==0||sum1==0&&sum2%2==0)System.out.println("YES");
        else System.out.println("NO");
    }
    
}
