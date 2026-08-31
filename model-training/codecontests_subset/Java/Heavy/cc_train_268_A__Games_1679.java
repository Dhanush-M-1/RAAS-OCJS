//package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

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
	
	public static void main(String[] args) throws IOException  {
		FastReader sc=new FastReader();
		int n=sc.nextInt();
		List<List<Integer>> list=new ArrayList<>();
		while(n-->0) {
			List<Integer> l=new ArrayList<>();
			l.add(sc.nextInt());
			l.add(sc.nextInt());
			list.add(l);
		}
		int ans=0;
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(i!=j) {
					List<Integer> home=list.get(i);
					List<Integer> away=list.get(j);
					if(home.get(0)==away.get(1)) {
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	/*		
	  
	  int n=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int c0=0,c1=0,c2=0;
			for(int e:arr) {
				if(e%3==0) {
					c0++;
				}
				else if(e%3==1) {
					c1++;
				}
                else if(e%3==2) {
                	c2++;
				}
			}
			List<Integer> list=new ArrayList<>();
			list.add(c0);list.add(c1);list.add(c2);
			Collections.sort(list);
			if(c0!=c1 && c1!=c2) {
				if(c1==list.get(0) ) {
					while(c0>c2) {
						c1++;
					}
				}
			}
			
			
		//	System.out.println(list.get(2)-list.get(1));
			System.out.println(c0+" "+c1+" "+c2);
			*/
		}
		
	
}

