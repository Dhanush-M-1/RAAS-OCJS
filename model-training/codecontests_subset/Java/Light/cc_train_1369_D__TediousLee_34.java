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
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		long arr[]=new long[2000005];
		arr[3]=1;
		arr[4]=1;
		arr[5]=3;
		int mod =1000000007;
		for(int i=6;i<=2000004;i++){

		    arr[i]=(((arr[i-2]*2)%mod)+(arr[i-1]%mod)+ ((i%3==0 ? 1:0)%mod))%mod;
		    
		}
		for(int test=0;test<t;test++){
		    int n=sc.nextInt();
		    System.out.println((arr[n]*4)%mod);
		    
		}
	}
}
