import java.util.Scanner;
import java.util.Vector;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        long n = sc.nextLong();
        
        Vector <Long> delit = delit(n);
        if (delit.size()==0)
        {
            System.out.println(1);
            System.out.print(0);
        }
        else
        {
            if (delit.size()==1)
                System.out.print(2);
            else
            {
                System.out.println(1);
                System.out.print(delit.get(0)*delit.get(1));
            }
        }
    }

    private static Vector<Long> delit(long n) {
        Vector <Long> del = new Vector <Long>();
        for (long i = 2; i*i<n+1; ++i)
            if (n%i==0)
            {
                n/=i;
                del.add(i);
                i--;
            }
        return del;
    }
}
