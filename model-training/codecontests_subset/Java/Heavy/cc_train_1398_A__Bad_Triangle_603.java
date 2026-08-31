/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
  public static void r(int arr[],int l,int m,int r) {
    int n1=m-l+1;
    int n2=r-m;
    int L[]=new int[n1];
    int R[]=new int[n2];
    for(int i=0;i<n1;i++)
    {
      L[i]=arr[l+i];
    }
    for(int j=0;j<n2;j++)
    {
      R[j]=arr[m+1+j];
    }
    int i=0;
    int j=0;
    int k=l;
    while(i<n1 && j<n2)
    {
      if(L[i]<=R[j])
      {
        arr[k]=L[i];
        ++i;
      }
      else{
        arr[k]=R[j];
        ++j;
      }
      ++k;
    }
    while(i<n1)
    {
      arr[k]=L[i];
      ++i;
      ++k;
    }
    while(j<n2)
    {
      arr[k]=R[j];
      ++j;
      ++k;
    }
}
public static void r2(int arr[],int l,int r)
{
  if(l<r)
  {
    int m=(l+r)/2;
    r2(arr,l,m);
    r2(arr,m+1,r);
    r(arr,l,m,r);

  }
}    
 static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}


	public static void main (String[] args) throws Exception
	{
		FastReader sc = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=sc.nextInt();	
		for(int test=0;test<t;test++){
		    int n=sc.nextInt();
		    long arr[]=new long[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextLong();
		    }
		    long aa=arr[0];
		    long bb=arr[1];
		    long ee=arr[n-3];
		    long cc=arr[n-1];
		    long dd=arr[n-2];
		    if(n>3){
		        long x=aa+bb;
		        long y=cc-dd;
		        if(cc>=x){
		            System.out.println(1+" "+2+" "+n);
		        }
		        else if(y>=ee){
		            System.out.println((n-2)+" "+(n-1)+" "+n);
		        }
		        else{
		            System.out.println("-1");
		        }
		        
		    }
		    else{
		        if((aa+bb)<=cc){
		            System.out.println(1+" "+2+" "+3);
		        }
		        else{
		            System.out.println("-1");
		        }
		    }
		}
		
	}
}
