//'main' method must be in a class 'Rextester'.
//openjdk version '11.0.5' 

import java.util.*;

//import java.lang.*;

public class Rextester {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t > 0) {
            long count = 0;
            long n = sc.nextLong();

            while (n != 1) {
                if (n % 3 == 0) {
                    if (n % 6 == 0)
                        n = n / 6;
                    else
                        n = n * 2;
                    count++;
                } else {
                    count = -1;
                    break;
                }

            }

            System.out.println(count);
            t--;
        }

        sc.close();

    }
}
