import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t,a,b,c,ans;
        t = sc.nextInt();
        while(t!=0)
        {
            a = sc.nextInt();
            b= sc.nextInt();
            c = sc.nextInt();
        
            if(c<a)
            {
                System.out.println(c);
            }
            else
            {
                ans = ((b/c)+1)*c;
                System.out.println(ans);
            }
        t--;
        }
    }
}
 