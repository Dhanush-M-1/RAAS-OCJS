import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class bulbs
{
    public static void main(String args[])
     {
        Scanner s=new Scanner(System.in);
        int n,m,i,j,x; 
        n=s.nextInt();
        m=s.nextInt();
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
      for(i=0;i<n;i++)
        {
            x=s.nextInt();
        for(j=0;j<x;j++)
        a.add(s.nextInt());
        for(j=1;j<=m;j++)
        {
              if(a.contains(j)==true&&b.contains(j)==false)
              b.add(j);
              }
            }
      if(b.size()==m)
      System.out.println("YES");
      else
      System.out.println("NO");
      }
    }