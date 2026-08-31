import java.io.*;
import java.util.*;
public final class GFG {
  
	public static void main (String[] args) {
	//	System.out.println("GfG!");
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	int m=scan.nextInt();
	int[] b=new int[n];
	int[] a=new int[m];
	for(int i=0;i<n;i++)
	   b[i]=scan.nextInt();
	   	
	   	for(int i=0;i<m;i++)
	   a[i]=scan.nextInt();
	   int sum=0;
Stack<Integer> s1 = new Stack<Integer>();	   
Stack<Integer> s = new Stack<Integer>();
Stack<Integer> s2 = new Stack<Integer>();
	for(int i=0;i<m;i++)
	{ Integer pos = (Integer) s2.search(a[i]);
	    if(pos==-1)
	    s2.push(a[i]);
	   
	}
//System.out.println(s2);	
for(int i=0;i<n&&(!s2.empty());i++)
{
   int c= s2.pop();
    s.push(c);
}

//System.out.println(s);
	//	reverse(s);
	for(int i=0;i<m;i++)
	{Integer pos1 = (Integer) s.search(a[i]);
	//	System.out.println(pos1+" "+a[i]);
	  
	  
	      for(int j=0;j<pos1-1;j++)
	      {  int a1=s.pop();
	          sum=sum+b[a1-1];
	          s1.push(a1);
	          //	System.out.println("sum"+sum);
	      }
	      

s.pop();
for(int j=0;j<pos1-1;j++)
	      {  int a1=s1.pop();
	          //sum=sum+a;
	          s.push(a1);
	      }
	      s.push(a[i]);
	  
	}
	System.out.println(sum);
	}
}