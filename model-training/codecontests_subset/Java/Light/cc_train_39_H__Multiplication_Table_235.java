import java.io.*;
import java.util.*;
public class j
{
public static void main(String a[])throws IOException
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
int k=0,t=0,j=0,p=0,m=0,i=0;
m=Integer.parseInt(b.readLine());
for(j=1;j<m;j++)
{
for(i=1;i<m;i++)
{
p=i*j;
while(p/m!=0)
{
k+=(p%m)*((int)Math.pow(10,t));
p=p/m;
t++;
}
k+=p*((int)Math.pow(10,t));
t=0;
System.out.print(k+" ");
k=0;
}
System.out.print("\n");
}
}
}