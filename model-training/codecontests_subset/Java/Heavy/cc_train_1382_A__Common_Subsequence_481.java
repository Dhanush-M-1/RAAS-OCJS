
import java.awt.Desktop;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;



public  class codechef3 {
static class comp implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(Math.abs(o1)>Math.abs(o2))
			return -1;
		else return 1;
	
	}

	
	}
	   
		 static class FastReader
		    {BufferedReader br; 
		        StringTokenizer st; 
		 public FastReader() 
		        {  br = new BufferedReader(new
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
	

		 
		 
		 public static boolean isPrime(int n)
		 {
			 for(int i=2;i<=Math.sqrt(n);i++)
			 {
				 if(n%i==0)
					 return false;;
				 
			 }
			 return true;
			 
			 
		 }
		
		 
		    public static void main(String[] args) 
		    {
		    	FastReader s=new FastReader();
		    int t=s.nextInt();
		    while(t-->0)
		    {
		      
		    	int n=s.nextInt();
		    	int m=s.nextInt();
		    	int[] a=new int[n];
		    	int[] b=new int[m];
		    	
		    	ArrayList<Integer> l=new ArrayList<>();
		    	for(int i=0;i<n;i++)
		    	{
		    		a[i]=s.nextInt();
		    		l.add(a[i]);
		    		
		    	}
		    	
		    	int ans=-1;
		    	
		    	int flag=0;
		    	for(int i=0;i<m;i++)
		    	{
		    		b[i]=s.nextInt();
		    		if(flag==0&&l.contains(b[i]))
		    		{
		    			ans=b[i];
		    			flag=-1;
		    		}
		    		
		    	}
		    	
		    	if(ans==-1)
		    		System.out.println("NO");
		    	else {
		    		System.out.println("YES");
		    		System.out.println("1 "+ans);
		    	}
		    	
		    	
		    	
		    	
		    	
		    	
		    }
		    
		    }
		    	
		       
		    }
		