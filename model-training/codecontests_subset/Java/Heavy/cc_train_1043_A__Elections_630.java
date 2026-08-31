import java.io.*;
import java.util.*;
 
public class Factor
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n, max = 0, totalA = 0, totalE = 0;
            n = Integer.parseInt(st.nextToken());
            int[] votes = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
            {
                  votes[i] = Integer.parseInt(st.nextToken());
                  if(votes[i] > max) max = votes[i];
                  totalE += votes[i];
            }
            
            for(int i=0; i<n; i++)
                  totalA += (max - votes[i]);
            while(totalA <= totalE)
            {
                  totalA += n;
                  max++;
            }
            System.out.println(max);
	}
}