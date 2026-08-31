import java.util.Scanner;
public class strhb {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t>0)
{
  int count=0;
 int n=s.nextInt();
 while(n%6==0)
{
   n/=6;
    count++;
}
while(n%3==0)
{
 n/=3;
count+=2;
}
if(n==1)
{
System.out.println(count);
}
else
{
System.out.println("-1");
}
  t--;
}      
 }
}
