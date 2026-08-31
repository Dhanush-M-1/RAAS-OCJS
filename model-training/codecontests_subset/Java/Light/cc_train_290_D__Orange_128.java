import java.io.*;
import java.util.*;
public class j
{
public static void main(String aa[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int i=0,m=0,n=0,k=0;
String s;
s=b.readLine();
m=Integer.parseInt(b.readLine());
s=s.toLowerCase();
n=s.length();
for(i=0;i<n;i++)
if(s.charAt(i)<(char)(97+m))
s=s.substring(0,i)+(char)((int)s.charAt(i)-32)+s.substring(i+1);
System.out.print(s);
}
}