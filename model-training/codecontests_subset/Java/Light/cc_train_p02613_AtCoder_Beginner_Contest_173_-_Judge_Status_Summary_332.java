import java.util.*;
public class Main
{
  public static void main(String args[])
  {
    Scanner in=new Scanner(System.in);
    int n;
    n=in.nextInt();
    int ac=0,wa=0,tle=0,re=0;
    for(int i=1;i<=n;i++)
    {
      String s=in.next();
      if(s.compareTo("AC")==0)
      {
        ac++;
      }
      else if(s.compareTo("TLE")==0)
      {
        tle++;
      }
      else if(s.compareTo("WA")==0)
      {
        wa++;
      }
      else
      {
        re++;
      }
    }
      System.out.println("AC x "+ac);
      System.out.println("WA x "+wa);
      System.out.println("TLE x "+tle);
      System.out.println("RE x "+re);
  }
}