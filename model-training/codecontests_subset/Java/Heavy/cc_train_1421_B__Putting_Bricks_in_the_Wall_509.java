	// _________________________RATHOD_____________________________________________________________
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
        int t=1;
        t=sc.nextInt();
        while(t>0)
        {
            t--;
            int n=sc.nextInt();
            char ar[][]=new char[n][n];
            for(int i=0;i<n;i++)
            {
                String s=sc.next();
                ar[i]=s.toCharArray();
            }
            int c=0;
            char v1=ar[0][1];
            char v2=ar[1][0];
            char v3=ar[n-1][n-2];
            char v4=ar[n-2][n-1];
            if(v1==v2&&(v3==v4)&&(v1!=v3))
            {
                System.out.println(0);
            }
            else if(v1!=v2&&v3!=v4)
            {
                System.out.println(2);
                if(v1=='1')
                System.out.println("1 2");
                else
                System.out.println("2 1");
                if(v3=='0')
                System.out.println(n+" "+(n-1));
                else
                System.out.println((n-1)+" "+(n));
            }
            else if(v1==v2&&(v3==v4)&&(v1==v3))
            {
                System.out.println(2);
                System.out.println(n+" "+(n-1));
                System.out.println((n-1)+" "+(n));
            }
            else if(v1==v2)
            {
              System.out.println(1);
              if(v3==v1)
              System.out.println(n+" "+(n-1));
              else
              System.out.println((n-1)+" "+(n));
            }
            else if(v3==v4)
            {
                System.out.println(1);
                if(v1==v3)
                System.out.println("1 2");
                else
                System.out.println("2 1");
            }
            
            
            
            
            
        }
        
        
    }        
      
    
     
} 