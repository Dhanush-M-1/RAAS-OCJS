


import java.util.*;
import java.io.*;

public class Main {
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
	public static void main(String args[]) {
		FastReader sc=new FastReader();
		int n=sc.nextInt();
		String S=sc.next();
		if(n<11 && toto(S.toCharArray(),'8')==0) System.out.println(0);
		else System.out.println(Math.min(S.length()/11, toto(S.toCharArray(),'8')));
		
	}
	public static int toto(char[] tab,char c) {
		int t=0;
		for(int i=0;i<tab.length;i++) {
			if(tab[i]==c) t++;
		}
		return t;
	}
}
