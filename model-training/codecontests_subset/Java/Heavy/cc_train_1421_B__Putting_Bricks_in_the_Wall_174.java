import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/* Name of the class has to be "Main" only if the class is public. */
public class Cp
{
	static int dp[][]=new int[1002][1002];
	 //	Template For Fast i/o copied From Gfg
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
		
	public static void main(String[] args) {
			
	   FastReader obj=new FastReader();
			
	   int t=obj.nextInt();
       while(t-->0)
	   {
    	  int n=obj.nextInt();
    	  char [][]mat=new char[n][n];
    	  
    	  for(int i=0;i<n;i++)
    	  {
    		  String s=obj.next();
    		  for(int j=0;j<n;j++)
    		  {
    			  mat[i][j]=s.charAt(j);
    		  }
    	  }
    	  char ch1=mat[0][1];
    	  char ch2=mat[1][0];
    	  
    	  char ch4=mat[n-1][n-2];
    	  char ch3=mat[n-2][n-1];
    	  
    	  if(ch1=='1' && ch2=='1')
    	  {
    		  if(ch3=='0' && ch4=='0')
    		  {
    			  System.out.println("0");
    		  }
    		  else if(ch3=='0' && ch4=='1')
    		  {
    			  System.out.println("1");
    			  System.out.println(n+" "+(n-1));
    		  }
    		  else if(ch3=='1' && ch4=='0')
    		  {
    			  System.out.println("1");
    			  System.out.println(n-1+" "+n);
    		  }
    		  else
    		  {
    			  System.out.println("2");
    			  System.out.println(n-1+" "+(n));
    			  System.out.println(n+" "+(n-1));
    		  }
    	  }
    	  else if(ch1=='0' && ch2=='0')
    	  {
    		  if(ch3=='1' && ch4=='1')
    		  {
    			  System.out.println("0");
    		  }
    		  else if(ch3=='0' && ch4=='1')
    		  {
    			  System.out.println("1");
    			  System.out.println(n-1+" "+n);
    		  }
    		  else if(ch3=='1' && ch4=='0')
    		  {
    			  System.out.println("1");
    			  System.out.println(n+" "+(n-1));
    		  }
    		  else
    		  {
    			  System.out.println("2");
    			  System.out.println(n-1+" "+n);
    			  System.out.println(n+" "+(n-1));
    		  }
    	  }
    	  else if(ch1=='0' && ch2=='1')
    	  {
    		  if(ch3=='1' && ch4=='1')
    		  {
    			  System.out.println("1");
    			  System.out.println("2 1");
    		  }
    		  else if(ch3=='0' && ch4=='1')
    		  {
    			  System.out.println("2");
    			  System.out.println("1 2");
    			  System.out.println(n+" "+(n-1));
    		  }
    		  else if(ch3=='1' && ch4=='0')
    		  {
    			  System.out.println("2");
    			  System.out.println("1 2");
    			  System.out.println(n-1+" "+(n));
    		  }
    		  else
    		  {
    			  System.out.println("1");
    			  System.out.println("1 2");
    		  }
    	  }
    	  else
    	  {
    		  if(ch3=='1' && ch4=='1')
    		  {
    			  System.out.println("1");
    			  System.out.println("1 2");
    		  }
    		  else if(ch3=='0' && ch4=='1')
    		  {
    			  System.out.println("2");
    			  System.out.println("2 1");
    			  System.out.println(n+" "+(n-1));
    		  }
    		  else if(ch3=='1' && ch4=='0')
    		  {
    			  System.out.println("2");
    			  System.out.println("2 1");
    			  System.out.println(n-1+" "+(n));
    		  }
    		  else
    		  {
    			  System.out.println("1");
    			  System.out.println("2 1");
    		  }  
    	  }
	   }
	}
}

