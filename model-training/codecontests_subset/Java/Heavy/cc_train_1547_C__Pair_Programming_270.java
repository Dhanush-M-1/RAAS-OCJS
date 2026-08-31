import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main7 {
 
	
	//@SuppressWarnings("unused")
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int t=sc.nextInt();
		//System.out.println();
		outer:while(t-->0) {
			System.out.println();
			int k=sc.nextInt();
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			int arr1[]=sc.readArray(n);
			int arr2[]=sc.readArray(m);
			
			int i=0;
			int j=0;
			int arr3[]=new int[n+m];
			int l=0;
			int kk=0;
			while(i!=n||j!=m) {
				if(i!=n&&arr1[i]==0) {
					k++;
					arr3[kk]=0;
					kk++;
					i++;
				}
				else if(j!=m&&arr2[j]==0) {
					k++;
					arr3[kk]=0;
					kk++;
					j++;
				}
				else if(i!=n&&arr1[i]<=k) {
					arr3[kk]=arr1[i];
					i++;kk++;
				}
				else if(j<m&&arr2[j]<=k) {
					arr3[kk]=arr2[j];
					j++;
					kk++;
				}
				else{
					System.out.println("-1");
				    continue outer;
				}
				
			}
			
			if(l==0) {
			for(int q=0;q<arr3.length;q++) {
				System.out.print(arr3[q]+" ");
			}
			}
			
			System.out.println();
			
			
			
			
			
		}
	
	}
	
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
 
		
		public float nextFloat() {
			// TODO Auto-generated method stub
			return Float.parseFloat(next());
		}
 
 
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
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