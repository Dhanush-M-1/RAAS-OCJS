import java.util.*;
public class cf653divB {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
for(int j=1;j<=t;j++)    
{int n=sc.nextInt();
int p2=0,p3=0;
while(n%2==0)
{n=n/2;p2++;}
while(n%3==0)
{n=n/3;p3++;}
if(n>1 || p2>p3)
System.out.println(-1);
else
System.out.println(p3-p2+p3);}
sc.close();}}