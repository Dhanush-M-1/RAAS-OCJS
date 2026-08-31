//package Div_2B_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Codeforce713_C {
	public static void main(String args[]) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		for(int t1=0;t1<t;t1++) {
			int k=fs.nextInt();
			int n=fs.nextInt();
			int m=fs.nextInt();
			int []arr1=new int[n];
			arr1=fs.readArray(n);
			int []arr2=new int[m];
			arr2=fs.readArray(m);
			int first=0;
			int second=0;
			int len=k;
			/*if(arr1[first]>len||arr2[second]>len)
			{
				System.out.println(-1);
				continue;
			}*/
			ArrayList<Integer> list=new ArrayList<>();
			boolean flag=false;
			while(first<n&&second<m) {
				if(arr1[first]==0) {
					len++;
					list.add(arr1[first++]);}
				else if(arr2[second]==0)
					{len++;
					list.add(arr2[second++]);}
				else {
					if(arr1[first]<=len)
						list.add(arr1[first++]);
					else if(arr2[second]<=len)
						list.add(arr2[second++]);
					else {
						flag=true;
						break;
					}
					//System.out.println("fuck");
					
				}
			}
			//System.out.println(flag);
			while(first<n&&!flag) {
				int add=arr1[first]==0?1:0;
				len+=add;
				if(arr1[first]>len)
				{
					flag=true;
					break;
				}
				list.add(arr1[first]);
				first++;
			}
			//System.out.println(flag);
			while(second<m&&!flag) {
				int add=arr2[second]==0?1:0;
				len+=add;
				if(arr2[second]>len) {
					flag=true;
					break;
				}
				list.add(arr2[second]);
				second++;
			}
			//System.out.println(list);
			//System.out.println(flag);
			if(flag)
				System.out.println(-1);
			else {
				for(int val:list)
					System.out.print(val+" ");
				System.out.println();
			}
			
		}
	}
	static final Random random=new Random();	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
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
	}
}
