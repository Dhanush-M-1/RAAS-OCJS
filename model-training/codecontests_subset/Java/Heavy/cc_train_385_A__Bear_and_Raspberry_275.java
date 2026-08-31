import java.util.*;

public class CF102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n=sc.nextInt();
       int c=sc.nextInt();
       int[] ar=new int[n];
       for(int i=0;i<n;i++){
           ar[i]=sc.nextInt();
       }
       int max=0;
       for(int i=0;i<n-1;i++){
           max=Math.max(ar[i]-ar[i+1]-c,max);
       }
        System.out.println(max);


    }



    public static long power(long a, long b, long c) {
        long ans = 1;
        while (b != 0) {
            if (b % 2 == 1) {
                ans = ans * a;
                ans %= c;
            }
            a = a * a;
            a %= c;
            b /= 2;
        }
        return ans;
    }

    public static long power1(long a, long b, long c) {
        long ans = 1;
        while (b != 0) {
            if (b % 2 == 1) {
                ans = multiply(ans, a, c);
            }
            a = multiply(a, a, c);
            b /= 2;

        }
        return ans;

    }

    public static long multiply(long a, long b, long c) {
        long res = 0;
        a %= c;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res + a) % c;
            }
            a = (a + a) % c;
            b /= 2;
        }

        return res % c;

    }

    public static long totient(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                //sum=sum+2*i;
                while (n % i == 0) {
                    n /= i;
                    // sum=sum+n;
                }
                result -= result / i;

            }
        }
        if (n > 1) {
            result -= result / n;

        }
        return result;
    }


    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static boolean[] primes(int n) {
        boolean[] p = new boolean[n + 1];
        p[0] = false;
        p[1] = false;
        for (int i = 2; i <= n; i++) {
            p[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (p[i]) {
                for (int j = i * i; j <= n; j += i) {
                    p[j] = false;
                }
            }

        }
        return p;
    }

    public int minimumLength(String s) {
        String s1 = "";
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i + 1);
            if (ch != ch1) {
                s1 = s1 + ch;

            }


        }
        s1 = s1 + s.charAt(s.length() - 1);
        String[] ar = s1.split("");
        for (int i = 0; i < s1.length() - 1; i++) {
            if (i <= s1.length() - 1 - i) {
                char ch1 = ar[i].charAt(0);
                char ch2 = ar[s1.length() - 1 - i].charAt(0);
                if (ch1 != ch2) {
                    break;
                } else {
                    ar[i] = "";
                    ar[s1.length() - 1 - i] = "";
                }
            } else {
                break;
            }

        }

        String s2 = "";
        for (String s3 : ar) {
            s2 = s2 + s3;
        }

        return s2.length();


    }

    public static long[] totientfrom1ton(long n) {
        long[] totient = new long[(int) (n + 1)];
        totient[0] = 0;
        totient[1] = 1;
        for (int i = 2; i <= n; i++) {
            totient[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (totient[i] == i) {
                totient[i] -= 1;
                for (int j = 2 * i; j <= n; j += i) {
                    totient[j] -= totient[j] / i;
                }
            }
        }
        return totient;

    }

    static long[] LcmSum(int n, long[] phi) {
        //ETF();
        long[] ans = new long[n + 1];

        for (int i = 1; i <= n; i++) {

            // Summation of d * ETF(d) where
            // d belongs to set of divisors of n
            for (int j = i; j <= n; j += i) {
                ans[j] += (i * phi[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            ans[i] = ((ans[i] + 1) * i) / 2;
        }

        /*int answer = ans[m];
        answer = (answer + 1) * m;
        answer = answer / 2;*/
        return ans;
    }

    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int c = 0;
        int lol = 0;
        process:
        while (lol <= (x.length - 1)) {


            int initial = x[lol];
            int nextno = initial + 2 * k;
            int low = lol + 1;
            int high = x.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (x[mid] <= nextno) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (ans != -1) {
                c++;
            }
            System.out.println(ans + " " + lol);
            lol = ans + 1;
        }
        return c;


    }
}
			  	     	 	  			 	 							 	