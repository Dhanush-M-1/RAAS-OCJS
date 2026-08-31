import java.util.*;
class Main
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] a=new int[4];
    Arrays.fill(a,0);
    for(int i=0;i<n;i++)
    {
      String s=sc.next();
      if(s.equals("AC"))
        a[0]++;
      else if(s.equals("WA"))
        a[1]++;
      else if(s.equals("TLE"))
        a[2]++;
      else 
        a[3]++;
    }
    System.out.println("AC x "+a[0]);
     System.out.println("WA x "+a[1]);
     System.out.println("TLE x "+a[2]);
     System.out.println("RE x "+a[3]);
    
  }
}