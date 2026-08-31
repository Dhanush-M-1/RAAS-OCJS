/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			br.readLine();
			StringTokenizer st = null;
			st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int[] arr1=new int[n];
			int[] arr2=new int[m];
	
			st=new StringTokenizer(br.readLine());//arrayindexoutofbound hai
			for(int i=0;i<n;i++){
				arr1[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++){
				arr2[i]=Integer.parseInt(st.nextToken());
			}
			int i=0;int j=0;
			int flag=0;
			List<Integer> al=new ArrayList<>();
			while(i<n && j<m){
				if(arr1[i]==0){
					al.add(0);
					k++;
					i++;
				}
				else if(arr2[j]==0){
					al.add(arr2[j]);
					k++;
					j++;
				}
				else if(arr1[i]<=k){
					al.add(arr1[i]);
					i++;
				}
				else if(arr2[j]<=k){
					al.add(arr2[j]);
					j++;
				}else{
					flag=1;
					break;
				}
			}
			if(flag==1){
				System.out.println("-1");
				continue;
			}
			while(i<n){
				if(arr1[i]==0){
					al.add(0);
					k++;
					i++;
				}
				else if(arr1[i]<=k){
					al.add(arr1[i]);
					i++;
				}else{
					flag=1;break;
				}
			}
			if(flag==1){
				System.out.println("-1");
				continue;
			}
			while(j<m){
				if(arr2[j]==0){
					al.add(0);
					k++;
					j++;
				}
				else if(arr2[j]<=k){
					al.add(arr2[j]);
					j++;
				}
				else{
					flag=1;
					break;
				}
			}
			if(flag==1){
				System.out.println("-1");
				continue;
			}
			for(int ele:al)
			System.out.print(ele+" ");
			System.out.println();
			
		}
	}
}