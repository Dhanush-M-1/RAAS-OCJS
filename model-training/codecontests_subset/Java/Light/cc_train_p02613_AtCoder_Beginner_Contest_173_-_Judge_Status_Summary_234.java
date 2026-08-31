import java.util.*;
class Main
{
public static void main(String args[])
{
    int a=0,w=0,r=0,t=0;
Scanner sc=new Scanner(System.in);
int n= sc.nextInt();
String s[]=new String[n];
sc.nextLine();

for(int i=0;i<n;i++)
{
s[i]=sc.nextLine();
}
for(int i=0;i<n;i++)
{
if(s[i].equals("AC"))
  a++;
if(s[i].equals("WA"))
  w++;
if(s[i].equals("TLE"))
 t++;
if(s[i].equals("RE"))
r++;
}
System.out.println("AC   x    "+ a);
System.out.println("WA  x   "+w);
System.out.println("TLE  x   "+t);
System.out.println("RE x   "+r);

}
}