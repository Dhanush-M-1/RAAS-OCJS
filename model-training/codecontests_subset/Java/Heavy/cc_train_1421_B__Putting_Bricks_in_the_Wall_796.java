import java.util.*;

public class Main {
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int z=0;z<t;z++)
    {
      int n=sc.nextInt();
      String temp=sc.nextLine();
      char ch[][]=new char[n][n];
      for(int i=0;i<n;i++)
      {
        String s=sc.nextLine();
        for(int j=0;j<n;j++)
        {
          ch[i][j]=s.charAt(j);
        }
      }
      int change=0;
      int x1=0,y1=0,x2=0,y2=0;
    if(ch[0][1]==ch[1][0])
    {
      if(ch[n-1][n-2]==ch[n-2][n-1])
      {
        if(ch[0][1]==ch[n-1][n-2])
        {
          change=2;
          x1=n;
          y1=n-1;
          x2=n-1;
          y2=n;
        }
      }
      else
      {
        change=1;
        if(ch[0][1]==ch[n-1][n-2])
        {
          x1=n;
          y1=n-1;
        }
        else
        {
          x1=n-1;
          y1=n;
        }
      }
    }
    else
    {
      if(ch[n-1][n-2]==ch[n-2][n-1])
      {
        if(ch[0][1]==ch[n-1][n-2])
        {
          change=1;
          x1=1;
          y1=2;
        }
        else
        {
          change=1;
          x1=2;
          y1=1;
        }
      }
      else
      {
        change=2;
        if(ch[0][1]=='1')
        {
          x1=1;
          y1=2;
        }
        else
        {
          x1=2;
          y1=1;
        }
        if(ch[n-1][n-2]=='0')
        {
          x2=n;
          y2=n-1;
        }
        else
        {
          x2=n-1;
          y2=n;
        }
      }
    }
    System.out.println(change);
    if(change==1)
    System.out.println(x1+" "+y1);
    else if(change==2)
    {
      System.out.println(x1+" "+y1);
      System.out.println(x2+" "+y2);
    }
    }
  }
}