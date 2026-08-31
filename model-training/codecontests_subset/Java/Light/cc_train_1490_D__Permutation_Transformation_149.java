/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    
    public static void tree(int l, int r,Map<Integer,Integer> ans,int [] a,int d){
        if(l>r){
            return;
        }
        int max=0; int maxi=-1;
        for(int i=l;i<=r;i++){
            if(max<a[i]){
                max=a[i];
                maxi=i;
            }
        }
        ans.put(max,d);
        tree(l,maxi-1,ans,a,d+1);
        tree(maxi+1,r,ans,a,d+1);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int T=sc.nextInt();
		for(int t=0;t<T;t++){
		    int n=sc.nextInt();
		    int []a=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
		    Map<Integer,Integer> ans=new HashMap<>();
		    tree(0,n-1,ans,a,0);
		    for(int i=0;i<n;i++){
		        sb.append(ans.get(a[i])+" ");
		    }
		    sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
