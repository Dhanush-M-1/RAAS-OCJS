import java.io.*;
import java.util.*;
import static java.lang.Math.*;
 public class Sample

{
     BufferedReader read;
     BufferedWriter write;
    public static void main(String args[]) throws Exception
    {
        new Sample().init("1");
    }
    int wt[],order[];
    ArrayList<Integer>ls;
     void init(String name) throws Exception
    {
        read= ri();//rf(name+".txt");
      int p[]=ia(read.readLine());
      int n=p[0];
      int m=p[1];
     wt=ia(read.readLine());
     order=ia(read.readLine());
     for(int i=0;i<m;i++)order[i]--;
     ls=new ArrayList<Integer>();
     boolean done[]=new boolean[n];
     
     for(int i:order)if(!done[i])
    	 {
    	 ls.add(i);
    	 done[i]=true;
    	 }
    
     long ans=0;
     for(int i:order)ans+=get(i);
     System.out.println(ans);
        read.close();
    }
int get(int in)
{
	int sum=0;
	int sz=ls.size();
	for(int i=0;i<sz;i++)
	{
		int t=ls.get(i);
		if(t==in)
			{
			ls.remove(i);
			ls.add(0,in);
			break;
			}
		else sum+=wt[t];
	}
	
	return sum;
}
void result(int ppp) throws Exception
{
  
}
boolean isPalindrome(long l)
{
   char c[]=(""+l).toCharArray();
   for(int i=0;i<c.length;i++)if(c[i]!=c[c.length-i-1])return false;
   return true;
}
int i(String s){return Integer.parseInt(s.trim());}
long l(String s){return Long.parseLong(s.trim());}
double d(String s){return Double.parseDouble(s.trim());}
 int[] ia(String s1){String s[]=s1.trim().split(" ");int p[]=new int[s.length];for(int i=0;i<s.length;i++)p[i]=Integer.parseInt(s[i]);return p;}
 long[] la(String s)
 {
     String s1[]=s.split(" ");
     long la[]=new long[s1.length];
     for(int i=0;i<s1.length;i++)la[i]=l(s1[i]);
     return la;
 }
 double [] ld(String s)
  {
    String s1[]=s.split(" ");
    int l=s1.length;
   double d[]=new double[l];
   for(int i=0;i<l;i++)d[i]=d(s1[i]);
   return d;
 }
static BufferedWriter wf(String s) throws Exception{return new BufferedWriter(new FileWriter(new File(s)));}
static BufferedReader rf(String s) throws Exception{return new BufferedReader(new FileReader(new File(s)));}
static BufferedReader ri() throws Exception{return new BufferedReader(new InputStreamReader(System.in));}
boolean st(int i,long num)
{
   return  ((num>>i)&1)!=0;
}


}

