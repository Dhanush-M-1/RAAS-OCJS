import java.util.*;
import java.lang.Math;
public class Team
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    long n=sc.nextLong();
    int tot=(int)Math.pow(5,n);
   
   String ss=String.valueOf(tot);
   int len=ss.length();
  
   if(len>2){
    System.out.println(25);}
  else
   {
     System.out.println(ss);
   }
  }
}