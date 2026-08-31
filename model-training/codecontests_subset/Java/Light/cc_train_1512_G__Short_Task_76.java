import java.util.*;
public class ShortTask {

    //The max value for which c = 10^7.
    static int limit = 10000001;

    static int[] d = new int[limit];

    public static void main(String[] args) {

        for(int i = 1; i < limit; i++) {
            for(int j = i; j < limit; j+=i) {
                d[j] += i;
            }
        }
        int[] sumOfDivisors = new int[limit];

        for(int i = limit - 1; i >= 1; i--)
            if(d[i] < limit)
                sumOfDivisors[d[i]] = i;

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if(sumOfDivisors[n] == 0)
                System.out.println("-1");
            else
                System.out.println(sumOfDivisors[n]);

        }
    }

}
