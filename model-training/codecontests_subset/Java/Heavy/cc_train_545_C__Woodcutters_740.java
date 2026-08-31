import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int trees=Integer.parseInt(br.readLine());
        int x[]=new  int[trees];
        int y[]=new int[trees];
        for (int i = 0; i <trees ; i++) {
            StringTokenizer s=new StringTokenizer(br.readLine());
             x[i]=Integer.parseInt(s.nextToken());
             y[i]=Integer.parseInt(s.nextToken());
        }

        int count=0;
        int right=x[trees-1];
        for (int i = trees-1; i >=0; i--) {

                 if (i==0||i==trees-1)
                 {
                     count++;
                 }
                 else
                     {


                             int cRight = x[i] + y[i];
                             int cLeft = x[i] - y[i];
                             if (cRight >= right) {
                                 if (cLeft > x[i - 1]) {
                                     count++;
                                     right = cLeft;
                                 } else {
                                     right = x[i];
                                 }
                             } else {
                                 count++;
                                 right = x[i];
                             }

                     }

        }
        System.out.println(count);
    }
}
