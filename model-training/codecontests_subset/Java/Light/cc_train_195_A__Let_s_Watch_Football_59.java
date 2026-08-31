import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main
{   
   public static void main(String[]arg) throws IOException
   {
        StringBuilder sol = new StringBuilder();   
        StringTokenizer tokens;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();        
        tokens = new StringTokenizer(line);
        boolean complex = false;
        int a = Integer.parseInt(tokens.nextToken());
        int b = Integer.parseInt(tokens.nextToken()); 
        int c = Integer.parseInt(tokens.nextToken());         
        int min = 0; int data = a*c; int i = 1;
        while(!complex)
        {
            int dp = b*i + c*b;
            if(dp >= data)
            {
                complex = true;
                min += 1;
            }
            else
            {
                i += 1;
                min += 1;
            }            
        }
        sol.append(min);
        System.out.print(sol);
   }
}

