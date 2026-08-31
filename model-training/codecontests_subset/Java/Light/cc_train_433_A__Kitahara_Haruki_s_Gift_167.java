
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w1=0,w2=0;
        for (int i=0;i<n;i++)
            if(sc.nextInt()==100)
                w1++;
            else w2++;

            if(w2%2==0 && w1%2==0)
            {
                System.out.println("YES");
            }
            else if(w2%2 !=0 && w1%2==0 && w1!=0)
                System.out.println("YES");
            else System.out.println("NO");
    }
}