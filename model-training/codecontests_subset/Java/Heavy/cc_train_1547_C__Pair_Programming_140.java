
import java.awt.Desktop;





import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
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
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.w3c.dom.Node;





public  class codechef3 {
static class comp implements Comparator<String>
{

	
	
	
	@Override
	public int compare(String o1, String o2) {
		if(o1.length()>o2.length())
			return 1;
		else if(o1.length()<o2.length())
			return -1;
		else return o1.compareTo(o2);
	 
	}
	
	}
      //=======================================================
	  //sorting Pair
   static class comp1 implements Comparator<Pair<Integer,Integer>>
   {

	@Override
	public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
		if(o1.k>o2.k)
			return 1;
		else return -1;
	
	}

	
	
	}
        //======================================================= 
	   
   //Creating Pair class  
         //----------------------------------------------------------------------
	    
       static class Pair<Integer,Intetger>
       {
    	   int k=0;
    	   int v=0;
    	   public Pair(int a,int b)
    	   {
    		   k=a;
    		   v=b;
    	   }
    	   public int getKey()
    	   {
    		   return k;
    		   
    	   }
    	   
    	   
       }
    
     //--------------------------------------------------------------------------
	
		 //gcd of two number
		 
		 
		    
		 //--------------------------------------------------------------------------------------------
		 
		 //lcm of two number
		
		    
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
		    
		   
		    
		  //-------------------------------------------------------------------------------------------
		    
		   
			public static void main(String[] args) 
		    {
		    	
		    	StringBuilder sb=new StringBuilder();
		    	FastReader s=new FastReader(); 
		         
	             int t=s.nextInt();
	             while(t-->0)
	             {
	            	int k=s.nextInt();
	            	int n=s.nextInt();
	            	int m=s.nextInt();
	            	int[] a=new int[n];
	            	
	            	int[] b=new int[m];
	            	
	            	for(int i=0;i<n;i++)
	            		a[i]=s.nextInt();
	            	for(int j=0;j<m;j++)
	            		b[j]=s.nextInt();
	            	int i=0;
	            	int j=0;
	            	int flag=0;
	            	ArrayList<Integer> l=new ArrayList<>();
	            	while(i<n||j<m)
	            	{
	            	
	            		if(i<n&&a[i]==0)
	            		{
	            			l.add(a[i]);
	            			k++;
	            			i++;
	            		}else if(j<m&&b[j]==0)
	            		{
	            			l.add(b[j]);
	            			k++;
	            			j++;
	            		}else if(i<n&&a[i]<=k)
	            		{
	            			l.add(a[i]);
	            			i++;
	            		}else if(j<m&&b[j]<=k)
	            		{
	            			l.add(b[j]);
	            			j++;
	            		}else
	            		{
	            			flag=1;
	            			break;
	            		}
	            		
	            		
	            	}
	            	if(flag==1)
	            		System.out.println("-1");
	            	else
	            	{
	            		for(Integer l1:l)
	            			System.out.print(l1+" ");
	            		System.out.println();
	            	}
	            	  
	            	  
	            	
	          
	          	             }
		
	     	    }
		    

}