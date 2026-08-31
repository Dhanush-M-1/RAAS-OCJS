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
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),odd=0,even=0;
		int[] a=new int[n];
		int sum=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			sum+=a[i];
			if(a[i]%2==0){
				even++;
			}
			else{
				odd++;
			}
		}
		int[] o=new int[odd], e=new int[even];
		even=0;odd=0;
		for(int i=0;i<n;i++){
			if(a[i]%2==0)e[even++]=a[i];
			else o[odd++]=a[i];
		}
		Arrays.sort(o);Arrays.sort(e);
		odd=o.length-1;even=e.length-1;
		boolean flag=false;int ans=0;
		while(true){
			if(!flag){if(odd==-1)break;ans+=o[odd--];flag=true;}
			else {if(even==-1)break;ans+=e[even--];flag=false;}
		}
		flag=true;int res=0;
		odd=o.length-1;even=e.length-1;
		while(true){
			if(!flag){if(odd==-1)break;res+=o[odd--];flag=true;}
			else {if(even==-1)break;res+=e[even--];flag=false;}
		}
		System.out.println((sum-Math.max(ans,res)));
	}
}