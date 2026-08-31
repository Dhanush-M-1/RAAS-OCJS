import java.io.*;
import java.util.*;

public class Main
{
      public static void main(String[] args) throws IOException 
	{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            long totalErrors = 0, cpy = 0;
            
            for(int i=0; i<3; i++)
            {
                  st = new StringTokenizer(br.readLine());
                  if(i == 0) 
                  {
                      for(int j=0; j<n; j++)
                      {
                          long err = Long.parseLong(st.nextToken());
                          totalErrors += err;
                      }
                      cpy = totalErrors;
                  }
                  else
                  {
                      for(int j=0; j<n-i; j++)
                      {
                          long err = Long.parseLong(st.nextToken());
                          totalErrors -= err;
                      }
                      System.out.println(totalErrors);
                      totalErrors = cpy - totalErrors;
                  }
            }
	}
}