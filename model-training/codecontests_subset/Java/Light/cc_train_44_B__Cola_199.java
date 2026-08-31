import java.io.*;
import java.util.*;
public class j
{
public static void main(String a[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int t=0,l=0,p=0,j=0,i=0,n=0,m=0,k=0;
String s;
s=b.readLine();
StringTokenizer c=new StringTokenizer(s);
n=Integer.parseInt(c.nextToken());
m=Integer.parseInt(c.nextToken());
k=Integer.parseInt(c.nextToken());
p=Integer.parseInt(c.nextToken());
for(i=0;i<=k;i++)
{
for(j=0;j<=p;j++)
{
l=(n-2*j-i)*2;
if(l<=m&&l>=0)
t++;
}
}
System.out.print(t);
}
}