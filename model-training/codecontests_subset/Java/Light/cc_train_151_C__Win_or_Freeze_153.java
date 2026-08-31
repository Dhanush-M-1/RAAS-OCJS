    import java.io.*;
    import java.util.*;
    
    public class WinOrFreeze {
        public static void main(String[] args) throws IOException {
            BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
            long n = Long.parseLong(f.readLine());
            if (n == 1)
            {
                System.out.println(1);
                System.out.println(0);
                return;
            }
            long p1 = 2;
            long p2 = 2;
            while (n % p1 != 0 && p1*p1 <= n)
                p1++;
            if (n % p1 != 0)
                p1 = n;
            n /= p1;
            if (n == 1)
            {
                System.out.println(1);
                System.out.println(0);
                return;
            }
            while (n % p2 != 0 && p2*p2 <= n)
                p2++;
            if (n % p2 != 0)
                p2 = n;
            n /= p2;
            if (n == 1)
                System.out.println(2);
            else
            {
                System.out.println(1);
                System.out.println(p1*p2);
            }
        }   
    }