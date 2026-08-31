//package contese_476;

import java.util.*;
import java.io.*;


public class q1 
{
	long[] st;
	int m=(int)1e9+7;
public class Node
{
	int a;
	char[] b;
	public Node(int a,char[] b)
	{
		this.a=a;
		this.b=b;
	}
}
 void SegmentTree(long[] a,int n)
{
	long x=(int)(Math.ceil(Math.log(n)/Math.log(2)));
   int max_size=(int)(2*Math.pow(2, x)+1);
	st=new long[max_size];
	CST(a,0,n-1,0);
	
}
 long CST(long[] a,int i,int j,int ind)
 {
	 if(i==j)
	 {
		 st[ind]=a[i];
		 return a[i];
	 }
	 int mid=i+(j-i)/2;
	 st[ind]=CST(a,i,mid,(2*ind+1))+CST(a,mid+1,j,(2*ind+2));
	 return st[ind];
 }
 long sum(int x,int y,int i,int j,int ind )
 {
	 if(x>=i&&y<=j)
		 return st[ind];
	 if(j<x||i>y)
		 return 0;
	 int mid=x+(y-x)/2;
	 return (sum(x,mid,i,j,(2*ind+1))+sum(mid+1,y,i,j,(2*ind+2)));
 }
public int mul(int a ,int b)
{
a=a%m;
b=b%m;
return((a*b)%m);
}
public int pow(int a,int b)
{
	int x=1;
	while(b>0)
	{
		if(b%2!=0)
			x=mul(x,a);
		a=mul(a,a);
		b=b/2;
	}
	return x;
}
public static long gcd(long a,long b)
{
	if(b==0)
		return a;
	else
		return gcd(b,a%b);
}
static int fun(ArrayList<Integer> a,PrintWriter out)
{
	//int n=a.size();
	
	if(a.size()==0)
		return -1;
	int f=0;
	while(true)
	{
		ArrayList<Integer> b=new ArrayList();	
		if(a.size()<=1)
			return(a.get(0));
		for(int i=0;i<a.size();i+=2)
		{
			if(i==a.size()-1)
			  b.add(a.get(i));
			
			if(i==a.size()-1)
				break;
			out.println(1+" "+a.get(i)+" "+a.get(i+1));
			//out.println('\n');
			//b.add(a.get(i));
			b.add(a.get(i+1));
		}
		a=b;
		//f=1;
	}
	//return(a.size());

}
long hcf(long a,long b)
{
	if(b==0)
		return a;
 return	hcf(b,a%b);
	
}
Boolean Bsearch(int[] a,int l,int r,long x)
{
	if(l>r)
		return false;
	int mid=(l+r)/2;
	if(a[mid]==x)
		return true;
	if(a[mid]<x)
	{
		l=mid+1;
		return Bsearch(a,l,r,x);
	}
	else
	{
		r=mid-1;
		return Bsearch(a,l,r,x);
	}
	
		
}

public static void main(String[] args)
{
     q1 obj = new q1();
     InputStream inputStream = System.in;
     OutputStream outputStream = System.out;
     InputReader in = new InputReader(inputStream);
     PrintWriter out = new PrintWriter(outputStream);
     Scanner sc=new Scanner(System.in);
     int n=in.nextInt();
	 int[] a=new int[n];
	 int max=Integer.MIN_VALUE;
	 int s=0;
	 for(int i=0;i<n;i++)
	 {
		 a[i]=in.nextInt(); 
		 s+=a[i];
		 if(a[i]>max)
			 max=a[i];
	 }
	 int num=2*s/n;
	 num=num+1;
	 if(num<max)
		 out.print(max);
	 else
		 out.print(num);
	 
	 //out.print((int)Math.ceil(4.0));
	 
		 
	 
	 out.flush();
	 out.close();
	
}

static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}
}