import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Three03C {
    public static void main(String[]args)throws IOException
    {
        PrintWriter out =new PrintWriter( System.out);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n=Integer.parseInt(br.readLine());
        int ar[][]=new int[n][2];
        int count=1;
        int gap;long x;
        for (int i=0;i<n;i++)
        {
            token=new StringTokenizer(br.readLine());
            ar[i][0]=Integer.parseInt(token.nextToken());
            ar[i][1]=Integer.parseInt(token.nextToken());
        }
        x=ar[0][0];
        for(int i=1;i<n-1;i++) {
            if (ar[i][0] - ar[i][1] > x) {
                count++;
                x = ar[i][0];
            } else if (ar[i][0] + ar[i][1] < ar[i + 1][0]) {
                count++;
                x = ar[i][0] + ar[i][1];
            } else {
                x = ar[i][0];
            }
        }
        if(n>=2)
        count++;
        out.println(count);
        out.close();
    }
}
