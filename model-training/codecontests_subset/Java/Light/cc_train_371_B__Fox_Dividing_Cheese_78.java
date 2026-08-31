import java.util.*;
 
public class Solution{
    public static long cnt2=0,cnt3=0,cnt5=0;
    public static long solve(long num){
      cnt2=0;cnt3=0;cnt5=0;
      while(num%2==0){
        cnt2++;
        num/=2;
      }
      while(num%3==0){
        cnt3++;
        num/=3;
      }
      while(num%5==0){
        cnt5++;
        num/=5;
      }
      return num;
    }
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    long a=sc.nextLong();
    long b=sc.nextLong();
    long x=solve(a);
    long a1=cnt2;
    long b1=cnt3;
    long c1=cnt5;
    long y=solve(b);
    long a2=cnt2;
    long b2=cnt3;
    long c2=cnt5;
    if(x!=y)
    System.out.print(-1);
    else
    System.out.print(Math.abs(a1-a2)+Math.abs(b1-b2)+
      Math.abs(c1-c2));
  }
}