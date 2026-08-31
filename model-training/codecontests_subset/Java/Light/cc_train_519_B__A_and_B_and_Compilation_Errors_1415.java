import java.util.Scanner; 
 public class errors{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
 int n=in.nextInt();long sum=0,sum1=0,sum2=0;int m=n-1,l=n-2;
while(n--!=0)
sum+=in.nextInt();
while(m--!=0)
sum1+=in.nextInt();
while(l--!=0)
sum2+=in.nextInt();
System.out.println(sum-sum1);
System.out.print(sum1-sum2);
 
}}