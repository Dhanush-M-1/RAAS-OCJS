import java.util.*;
 
public class Solution{
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    long n=sc.nextLong();
    long x=sc.nextLong();
    long y=sc.nextLong();
    long p=(long)Math.ceil((double)n*(double)(y)/(double)100);
    if(p-x<=0)
    System.out.print(0);
    else
    System.out.print(p-x);
  }
}