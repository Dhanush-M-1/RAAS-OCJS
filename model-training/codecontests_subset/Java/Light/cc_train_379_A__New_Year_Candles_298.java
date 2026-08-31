import java.io.*;
import java.util.*;
public class Main
{
   public static void main(String[] args)
  {
  Scanner s=new Scanner(System.in);
  int p=s.nextInt();
  int q=s.nextInt();
  for(int i=1;i<=p;i++)
     if(i%q==0)
         p++;
      System.out.println(p);
  }
}