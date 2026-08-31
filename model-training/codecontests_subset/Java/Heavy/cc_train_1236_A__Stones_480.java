import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;


public class Codeforces {
    public static void main(String[] args) throws IOException {
//        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(s.readLine());
//        for(int i=0;i<t;i++) {
//            int n=Integer.parseInt(s.readLine());
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++)
        {
            int x=s.nextInt();
            int y=s.nextInt();
            int z=s.nextInt();
            int count=0;
            int val=z/2;
            int v=Math.min(y,val);
            y-=v;
            count+=v;

            val=y/2;
            v=Math.min(x,val);
            x-=v;
            count+=v;
            count*=3;
            System.out.println(count);
        }

    }
}
//class Pair{
//    long x,y;
//    Pair(long x,long y)
//    {
//        this.x=x;
//        this.y=y;
//    }
//}

