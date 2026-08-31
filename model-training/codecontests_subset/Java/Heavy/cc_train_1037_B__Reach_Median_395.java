import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class B{
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
	
	public static void main(String[] args) 
	{
		OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int ar[] = new int[n];
        
        for(int i = 0; i < n; i++)
        {
        	ar[i] = sc.nextInt();
        }
        
        Arrays.sort(ar);
        
        int mid = n/2;
        
        long upd = 0;
        if(ar[mid] < m)
        {	
        	int i = mid;
        	while(i < n && ar[i] < m)
        	{
        		upd += m-ar[i];
        		i++;
        	}
        }
        
        else
        {
        	int i = mid;
        	while(i >= 0 && ar[i] > m)
        	{
        		upd += ar[i]-m;
        		i--;
        	}
        }
        out.println(upd);
        out.close();
	}

}
