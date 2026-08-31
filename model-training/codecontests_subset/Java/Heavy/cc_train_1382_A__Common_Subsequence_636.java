import java.math.BigInteger;
import java.util.*;

public class CompetitiveProgramming {
    static int[] sieveOfEratosthenes(int n) {
        int[] primes = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            primes[i] = 1;
        }
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2; i * j <= n; j++) {
                if (primes[i] == 1) {
                    primes[i * j] = 0;
                }
            }
        }
        return primes;
    }

    static int fastExponent(int a, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return a;
        } else {
            if (n % 2 == 1) {
                return a * fastExponent(a, n - 1);
            } else {
                return fastExponent(a * a, n / 2);
            }

        }
    }

    static int modExponent(int a, int n, int m) {
        if (n == 0) {
            return 1 % m;
        } else if (n == 1) {
            return a % m;
        } else {
            if (n % 2 == 0) {
                int y = modExponent(a, n / 2, m);
                return (y * y) % m;
            } else {
                return ((a % m) * (modExponent(a, n - 1, m))) % m;
            }
        }
    }


    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    //ax+by=gcd(a,b) // find x & y
    static int extendedGCD(int a, int b, int x, int y) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int x1 = 0;
        int y1 = 0;
        int d = extendedGCD(b % a, a, x1, y1);
        x = y1;
        y = x1 - y1 * (a / b);
        return d;
    }

    static int LCM(int a, int b) {
        return ((a * b) / gcd(a, b));
    }
    /* BIGINTEGER JAVA USE
    String x=""+countn;
            BigInteger N=new BigInteger(x);
            System.out.println(N.multiply(BigInteger.valueOf(countm)));
            BigInteger l=sc.nextBigInteger();
            BigInteger r=sc.nextBigInteger();
            System.out.println("YES");
            for (BigInteger bi = l; r.compareTo(bi) > 0; bi = bi.add(BigInteger.valueOf(2))) {
                BigInteger x= bi.add(BigInteger.valueOf(1));
                System.out.println(bi + " "+ x);
            }

            }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //int h=sc.nextInt();
        //int n=sc.nextInt();
        //Map<Integer,Integer> hashmap=new HashMap<>();
        //int[] arr=sieveOfEratosthenes(15);
        //int[] arr = new int[n];
        //ArrayList<Integer> arrayList=new ArrayList<>();
        // Advanced For-Loop
        //for (Integer num : arrlist) {
        //    System.out.println(num);
        //}
        //freq[i]=Integer.parseInt(String.valueOf(charInt[i])); //conversion of char array to int array
        int t=sc.nextInt();
        for(int k=0;k<t;k++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            HashSet<Integer> hs=new HashSet<>();
            int arrn[]=new int[n];
            int arrm[]=new int[m];
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                hs.add(x);
            }
            int num=-1;
            for(int i=0;i<m;i++){
                int y=sc.nextInt();
                if(hs.contains(y)){
                    num=y;
                }
            }
            if(num==-1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
                System.out.println(1+" "+num);
            }

        }
    }
}


