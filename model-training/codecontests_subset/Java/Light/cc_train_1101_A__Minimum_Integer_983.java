import java.util.*;

public class pro
{
    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);
    //   String s =sc.nextLine();
      int c=0;
      int a=sc.nextInt();
      for(int i=0;i<a;i++)
      {
        int l =sc.nextInt();
        int r =sc.nextInt();
        int d =sc.nextInt();
            if(d*1>=l)
                System.out.println(((r/d)+1)*d);
            else
                System.out.println(d*1);
      }
    }
}