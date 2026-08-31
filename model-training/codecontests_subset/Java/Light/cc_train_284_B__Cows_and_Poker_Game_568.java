import java.io.*;
import java.util.*;
public class j
{
public static void main(String a[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int p=0,q=0,n=0,r=0,i=0;
n=Integer.parseInt(b.readLine());
String s;
s=b.readLine();
for(i=0;i<n;i++)
{
if(s.charAt(i)=='A')
p++;
if(s.charAt(i)=='I')
q++;
if(s.charAt(i)=='F')
r++;
}
if(q>1)
System.out.print("0");
else
{
if(q==1)
System.out.print("1");
else
{
System.out.print(p);
}
}
}
}