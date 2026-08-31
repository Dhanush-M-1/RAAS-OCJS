import java.util.*;
import java.io.*;
import java.lang.*;

public class Test {

    public static String ans(int []arr1, int []arr2 , int n, int m){
    	
    	int carr[][] = new int[n][m];
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(arr1[i]==arr2[j]) {
    				return ("YES\n"+1 + " "+arr1[i]); 
    			}
    		}
    	}
    	
    	return "NO";

    }
    
    public static void main(String args[]) {
        FastReader scn = new FastReader();
        StringBuffer sb = new StringBuffer();
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int m = scn.nextInt();
            int []arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            int []arr2 = new int[m];
            for(int i=0;i<m;i++){
                arr2[i] = scn.nextInt();
            }
            
            sb.append(ans(arr,arr2,n,m) + "\n");

        }
        System.out.println(sb);
    }
//-----------------------fastreader-----------------------------------
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

}