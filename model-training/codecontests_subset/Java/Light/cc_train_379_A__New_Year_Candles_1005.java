import java.util.*;
import java.io.IOException;
public class svechi {
    public static void main (String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int max=a;
        int n=0;
        int m;
        while(true)
        {
         m=n;
         n=(a+n)%b;
         a=(a+m)/b;
if(a==0)break;
         max=max+a;
        }
        System.out.println(max);

    }
}
