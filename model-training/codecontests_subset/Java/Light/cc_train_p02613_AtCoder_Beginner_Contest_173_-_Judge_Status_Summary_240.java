import java.util.*;

public class Main
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    ArrayList<String> al=new ArrayList();
    for(int i=0;i<N;i++)
      al.add(sc.next());
    int a=0,w=0,t=0,r=0;
    for(String S:al)
    {
      //System.out.println(S);
      if(S.equals("AC"))
        a++;
      else if(S.equals("WA"))
        w++;
      else if(S.equals("TLE"))
        t++;
      else
        r++;
    }
    System.out.println("AC x "+a);
    System.out.println("WA x "+w);
    System.out.println("TLE x "+t);
    System.out.println("RE x "+r);
  }
}