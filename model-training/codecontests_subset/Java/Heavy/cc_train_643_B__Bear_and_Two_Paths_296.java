import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class codeforces {
   
	public static void main(String[] args) {
			
     scanner in  = new scanner();
     int n = in.nextInt();
     int k = in.nextInt();
    ArrayList<Integer> no = new ArrayList<>();
    for(int i = 0;i<4;i++)
    	no.add(in.nextInt());
     if(n>=5 && k>=n+1)
     {    	
    	 System.out.print(no.get(0)+" "+no.get(2)+" ");
    	 for(int i = 1;i<=n;i++)
    		 if(!no.contains(i))
    			 System.out.print(i+" ");
    	 System.out.println(no.get(3)+" "+no.get(1)+" ");
    	 System.out.print(no.get(2)+" "+no.get(0)+" ");
    	 for(int i = 1;i<=n;i++)
    		 if(!no.contains(i))
    			 System.out.print(i+" ");
    	 System.out.println(no.get(1)+" "+no.get(3)+" ");
     }
     else
    	 System.out.println(-1);
	}
}
class scanner
{
	BufferedReader br ;
	StringTokenizer st;
	
	public scanner()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = null;
	}
	 public String next() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }
	public int nextInt()
	{
		return Integer.parseInt(next());
	}
	public long nextLong()
	{
	  return	Long.parseLong(next());
	}
}