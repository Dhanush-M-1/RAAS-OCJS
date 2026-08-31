//Author: lusifer97

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
public class main
{
static class FastReader
{
BufferedReader br;
StringTokenizer st;
public FastReader()
{
br = new BufferedReader(new InputStreamReader(System.in));
}
String next()
{
while (st == null || !st.hasMoreElements())
{
try{
st = new StringTokenizer(br.readLine());
}
catch (IOException e)
{
e.printStackTrace(); }
}
return st.nextToken();

}
int nextInt()
{
return Integer.parseInt(next());
}
long nextLong()
{
return Long.parseLong(next());
}
double nextDouble()
{
return Double.parseDouble(next());
}
String nextLine()
{
String str = "";
try
{
str = br.readLine();
}
catch (IOException e)
{
e.printStackTrace();
}
return str;
}
int[] arrinput(int n) {
int[] a=new int[n];
for (int i=0; i<n; i++) a[i]=nextInt();
return a;
		}
}

public static void main(String[] args)throws Exception
{
FastReader sc=new FastReader();
int t=sc.nextInt();
while(t-->0)
{
int n=sc.nextInt();
int m=sc.nextInt();
ArrayList<Integer> al1=new ArrayList<>();
ArrayList<Integer> al2=new ArrayList<>();
for(int i=0;i<n;i++)
al1.add(sc.nextInt());
for(int i=0;i<m;i++)
al2.add(sc.nextInt());
boolean bool=false;
int res=0;
for(int i=0;i<n&&bool==false;i++)
{
int x=al1.get(i);
if(al2.contains(x))
{
bool=true;
res=x;
}
}
if(bool==true){
System.out.println("YES");
System.out.println("1 "+res);
}
else
System.out.println("NO");
}
}
}












