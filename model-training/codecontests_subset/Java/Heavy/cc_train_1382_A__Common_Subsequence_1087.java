/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{   
	public static void main (String[] args) throws java.lang.Exception
	{  FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int t=1;
        t=in.nextInt();
        while(t>0){
            --t;
            int n=in.nextInt();
            int m=in.nextInt();
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++)
            {   int a=in.nextInt();
                set.add(a);
            }
            int ans=-1;
            for(int i=0;i<m;i++)
            {
                int a=in.nextInt();
                if(set.contains(a))
                  ans=a;
            }
            if(ans<0)
            System.out.println("NO");
            else 
            System.out.println("YES\n"+"1 "+ans);
        }
	    
	}
	
    static int upper_bound(int arr[],int x){
	    int a=Arrays.binarySearch(arr,x);
	    if(a<0){
	        a*=(-1);
	    
	        return a-1; 
	    }
	    else{
	        
	        while(a<arr.length && arr[a]==x)
	           ++a;
	           return a;
	    }
	}
	static long gcd(long a ,long b)
	{
    if(a==0)
    return b;
    else return gcd(b%a,a);
    }
    
//------making a Fendwick tree ---//
	// creating a fendwick tree
	static long ftree[];
	static void buildFendwicktree(int arr[],int n)
	{
		ftree=new long[n+1];
		for(int i=0;i<n;i++)
			upftree(arr[i],i,n);
	}
	static void upftree(int value,int n,int i)
	{
		int index=i+1;
		while(index<=n)
		{
		  ftree[index]+=value;
		  index+=(index&(-index));  // adding last bit to the index 
		}
	}
	static long getSum(int index)
	{
		long sum=0;
		index+=1;
		while(index>0)
		{
			sum+=ftree[index];
			index-=(index&(-index)); // fliping last index of the tree; 
		}
		return sum;
	}
//------Fendwick tree ends ---------//
}


class sgmtree{
    int arr[];
    sgmtree(int input[],int n){
        arr=new int[100001];
        buildtree(input,1,0,n-1);
    }
    void buildtree(int input[],int si,int ss,int se){
        if(ss==se){
         arr[si]=input[ss];
         return;
        }
         int mid=(ss+se)/2;
         buildtree(input,2*si,ss,mid);
         buildtree(input,2*si+1,mid+1,se);
         arr[si]=Math.min(arr[2*si],arr[2*si+1]);
         
    }
    int query(int si,int ss,int se,int qs,int qe){
        if(qs>se  || qe<ss)
         return Integer.MAX_VALUE;
        
        if(ss>=qs && qe>=se)
        return arr[si];
        
        int mid=(ss+se)/2;
        int l=query(2*si,ss,mid,qs,qe);
        int r=query(2*si+1,mid+1,se,qs,qe);
        return Math.min(l,r);
    }
    void update(int input[],int index,int value){
        input[index]=value;
        updateutils(input,1,0,input.length-1,index);
    }
    void updateutils(int input[],int si,int ss,int se,int qi){
        if(ss==se){
            arr[si]=input[ss];
            return;
        }
        int mid=(ss+se)/2;
        if(qi<=mid)
        updateutils(input,2*si,ss,mid,qi);
        else
        updateutils(input,2*si+1,mid+1,se,qi);
        arr[si]=Math.min(arr[2*si],arr[2*si+1]);
    }
    
}
	
	/* This is for sorting first accorting to gain[1] if gain[1] is same the gain[0]
Arrays.sort(gain, (long[] l1, long[] l2) -> {
	        if(l1[1] != l2[1])return Long.compare(l2[1], l1[1]);//Sorting in non-increasing order of gain
	        return Long.compare(l1[0], l2[0]);//Choosing smallest bit among all bits having same gain
	    });
*/

class pair{
    int x,y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}	
class CompareValue { 
  
    static void compare(pair arr[], int n) 
    { 
        Arrays.sort(arr, new Comparator<pair>() { 
        public int compare(pair p1, pair p2) 
            { 
                return p1.y - p2.y; 
            } 
        }); 
    } 
}
class CompareKey{
    static void compare(pair arr[],int n){
        Arrays.sort(arr,new Comparator<pair>(){
            public int compare(pair p1,pair p2)
            {
                return p2.x-p1.x;
            }
        });
    }
}
class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    String nextLine() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c != 10 && c != 13; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    char nextChar() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        return (char) c;
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}	