import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
 import java.util.*; 
public class Main 
{ 
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
        FastReader sc=new FastReader();
       StringBuilder sb1=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
        	long l = sc.nextLong();
        	long r = sc.nextLong();
        	long fi = 2 * (n - 1);
        	int start = 0;
        	long ans = 0L;
        	long tmp = l - 1L;
        	while(fi > 0) {
        		if(ans + fi > tmp) break;
        		ans += fi;
        		fi -= 2L;
        		start++;
        	}
        	start++;
        	long off = (l - ans);
        	long ll = l - 1;
        	int can = (int) (start + off / 2);
        	if(off % 2 == 0) {
        		ll++;
        		sb1.append(can+" ");
        	}
        	
        	while(ll < r && start < n ) {
            	for(int i = can + 1 ; i <= n && ll < r ; i++ ) {
            		sb1.append(start+" ");
            		ll++;
            		if(ll == r) break;
            		sb1.append(i+" ");
            		ll++;
            	}
            	start ++;
            	can = start;
 
        	}
        	if(start == n && ll < r) {
        		sb1.append(1);
        	}
        	sb1.append("\n");
        }
      
        
        System.out.print(sb1.toString());
    
    
     }
     
   
 
}