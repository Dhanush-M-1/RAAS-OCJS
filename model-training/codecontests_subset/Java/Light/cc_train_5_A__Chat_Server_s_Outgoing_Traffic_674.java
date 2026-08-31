import java.io.*;
import java.util.*;
public class j
{
public static void main(String a[])throws IOException
{
Scanner b=new Scanner(System.in);
String s="\0";
int n=0,m=0;
while(b.hasNextLine())
{
s=b.nextLine();
if(s.charAt(0)=='+')
n++;
else
{
if(s.charAt(0)=='-')
n--;
else
m+=((s.length()-s.indexOf(':')-1)*n);
}
}
System.out.print(m);
}
}