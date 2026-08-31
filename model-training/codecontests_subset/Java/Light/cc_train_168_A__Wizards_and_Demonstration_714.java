import java.io.*;
import java.util.*;
public class j
{
public static void main(String a[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int m=0,i=0,r=0,n=0;
double j;
String p;
p=b.readLine();
StringTokenizer c=new StringTokenizer(p);
n=Integer.parseInt(c.nextToken());
m=Integer.parseInt(c.nextToken());
r=Integer.parseInt(c.nextToken());
j=n*r/100.0;
i=(int)j;
if(j-i!=0)
i++;
if(i>m)
System.out.print(i-m);
else
System.out.print("0");
}
}