import java.util.*;
import java.io.*;
public class Regex
{

public static void main(String args[])throws IOException
{
BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
Scanner ob=new Scanner(System.in);
int n=ob.nextInt(),c=0;
int m=ob.nextInt();
while(n>0)
{
c++;
if(c%m==0)
n++;
n--;
}
System.out.println(c);
}}