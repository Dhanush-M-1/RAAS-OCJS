    import java.util.*;
    import java.lang.Math; 
    import java.util.Arrays;
    import java.util.Scanner;
    import java.util.stream.IntStream;
    import java.io.OutputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.PrintWriter;
     
    public class Problem {
       	public static void main(String[] args) {
    	   InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            TaskA solver = new TaskA();
            solver.solve(1, in, out);
            out.close();
    	}
    	
    	static class TaskA {
          public void solve(int testNumber, Scanner in, PrintWriter out) {
                  int c1 = in.nextInt();
                  int c2 = in.nextInt();
                  int c3 = in.nextInt();
                  int c4 = in.nextInt();
                  int c5 = in.nextInt();
                  int sum=0;
                  if(c1==0 && c2==0 && c3==0 && c4==0 && c5==0){
                       out.print("-1");
                  }else{
                       sum = c1+c2+c3+c4+c5;
                       if(sum%5==0){
                            sum = sum/5;
                            out.print(sum);
                       }
                       else{
                            out.print("-1");
                       }
                  }        
                  
          }
    	}
     
    	
    public int factorial(int n) {
            int fact = 1;
            int i = 1;
           while(i <= n) {
             fact *= i;
             i++;
           }
            return fact;
    }
     
    public static int BinarySearch(long temp,long[] sum,int r)
    {
    	int l=0;
    	
    	while(l<=r)
    	{
    		int mid=l+(r-l)/2;
    		if(sum[mid]==temp&&sum[mid]!=-1)
    		{
    		return mid;
    		}
    		if(sum[mid]>temp&&sum[mid]!=-1)
    			r=mid-1;
    		if(sum[mid]<temp&&sum[mid]!=-1)
    			l=mid+1;
        }
    	return -1;
    }
    public static long gcd(long x,long y)
    {
    	if(x%y==0)
    		return y;
    	else
    		return gcd(y,x%y);
    }
    public static int gcd(int x,int y)
    {
    	if(x%y==0)
    		return y;
    	else 
    		return gcd(y,x%y);
    }
    public static int abs(int a,int b)
    {
    	return (int)Math.abs(a-b);
    }
    public static long abs(long a,long b)
    {
    	return (long)Math.abs(a-b);
    }
    public static int max(int a,int b)
    {
    	if(a>b)
    		return a;
    	else
    		return b;
    }
    public static int min(int a,int b)
    {
    	if(a>b)
    		return b;
    	else 
    		return a;
    }
    public static long max(long a,long b)
    {
    	if(a>b)
    		return a;
    	else
    		return b;
    }
    public static long min(long a,long b)
    {
    	if(a>b)
    		return b;
    	else 
    		return a;
    }
     
     
    public static long pow(long n,long p,long m)
    {
    	 long  result = 1;
    	  if(p==0)
    	    return 1;
    	if (p==1)
    	    return n;
    	while(p!=0)
    	{
    	    if(p%2==1)
    	        result *= n;
    	    if(result>=m)
    	    result%=m;
    	    p >>=1;
    	    n*=n;
    	    if(n>=m)
    	    n%=m;
    	}
    	return result;
    }
    public static long pow(long n,long p)
    {
    	long  result = 1;
    	  if(p==0)
    	    return 1;
    	if (p==1)
    	    return n;
    	while(p!=0)
    	{
    	    if(p%2==1)
    	        result *= n;	    
    	    p >>=1;
    	    n*=n;	    
    	}
    	return result;
     
    }
     
    static long sort(int a[]){  
         int n=a.length;
    	int b[]=new int[n];	
    	return mergeSort(a,b,0,n-1);
         
    }
     
    static long mergeSort(int a[],int b[],long left,long right){
         long c=0;
         if(left<right){   
          long mid=left+(right-left)/2;
    	 c= mergeSort(a,b,left,mid);
    	 c+=mergeSort(a,b,mid+1,right);
    	 c+=merge(a,b,left,mid+1,right); 
         }	
    	return c;	 
    }
    static long merge(int a[],int  b[],long left,long mid,long right){
         long c=0;int i=(int)left;int j=(int)mid; int k=(int)left;
         while(i<=(int)mid-1&&j<=(int)right){ 
              if(a[i]<=a[j]){
                   b[k++]=a[i++]; 
              }
              else{ 
                   b[k++]=a[j++];c+=mid-i;
              }
         }
         
         while (i <= (int)mid - 1)   
                 b[k++] = a[i++]; 
         while (j <= (int)right)
                 b[k++] = a[j++];
         for (i=(int)left; i <= (int)right; i++) 
    	        a[i] = b[i];
    	        return c; 
         }
     
    }