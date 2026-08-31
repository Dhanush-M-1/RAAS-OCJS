import java.io.*;
import java.util.*;

public class Solution {

    /* -------------------------------------- Main Start ----------------------------------- */
    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(fs.nextLine().trim());
        fs.nextLine();
        while (t-- > 0) {
            int k = fs.nextInt();
            int n = fs.nextInt();
            int m = fs.nextInt();
            Queue<Integer> a = new LinkedList<>();
            Queue<Integer> b = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                a.add(fs.nextInt());
            }
            for (int i = 0; i < m; i++) {
                b.add(fs.nextInt());
            }
            boolean isPoss = true;
            ArrayList<Integer> pos = new ArrayList<>();
            while (a.size() > 0 || b.size() > 0) {
                if (a.size() > 0) {
                    int val = a.peek();
                    if (val <= k) {
                        int x = a.poll();
                        pos.add(x);
                        if(val == 0) k++;
                        continue;
                    }
                }
                if (b.size() > 0) {
                    int val = b.peek();
                    if (val <= k) {
                        int x = b.poll();
                        pos.add(x);
                        if(val == 0) k++;
                        continue;
                    }
                }
                isPoss = false;
                break;
            }

            if (!isPoss || ((n + m) != pos.size())) {
                sb.append("-1\n");
            } else {
                for (int i = 0; i < pos.size(); i++) {
                    sb.append(pos.get(i) + " ");
                }
                sb.append("\n");
            }
            fs.nextLine();

        }
        System.out.println(sb);

    }


    /* ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
  
      StringBuilder sb = new StringBuilder();
      sb.append(x + "\n");
    
      Collections.sort(arr, (a, b) -> Integer.compare(a[0], b[0]))
      arr.toArray(new int[arr.size()][])
    
     */
    private static final int MOD_1 = 1000000000 + 7;

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws IOException {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        /* --------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
        void printArray(int[] arr) {
            System.out.println(Arrays.toString(arr));
        }

        void printArray(String[] arr) {
            System.out.println(Arrays.toString(arr));
        }

        void printArray(long[] arr) {
            System.out.println(Arrays.toString(arr));
        }

        void print(int data) {
            System.out.println(data);
        }

        void print(String data) {
            System.out.println(data);
        }

        void print(long data) {
            System.out.println(data);
        }

        int[] II(int n) throws IOException {
            int[] d = new int[n];
            String[] arr = nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(arr[i]);
            }

            return d;
        }

        String[] IS(int n) throws IOException {
            return nextLine().split(" ");
        }

        long[] IL(int n) throws IOException {
            long[] d = new long[n];
            String[] arr = nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                d[i] = Long.parseLong(arr[i]);
            }
            return d;
        }

        public long gcd(long a, long b) {
            if (a == 0) {
                return b;
            }
            return gcd(b % a, a);
        }

        public long power(long x, long y, long p) {
            long res = 1;
            x = x % p;
            if (x == 0) {
                return 0;
            }

            while (y > 0) {
                if ((y & 1) == 1) {
                    res = (res * x) % p;
                }
                y = y >> 1;
                x = (x * x) % p;
            }
            return res;
        }

        void sieveOfEratosthenes(boolean prime[], int size) {
            Arrays.fill(prime, true);
            prime[0] = prime[1] = false;
            prime[2] = true;

            for (int p = 2; p * p < size; p++) {
                if (prime[p] == true) {
                    for (int i = p * p; i < size; i += p) {
                        prime[i] = false;
                    }
                }
            }
        }

        public long fact(long n) {
            long ans = 1;
            for (int i = 2; i <= n; i++) {
                ans = (ans * i) % MOD_1;
            }
            return ans;
        }

        public long lcm(long a, long b) {
            return (a * b) / gcd(a, b);
        }

        public int log2(int N) {
            int result = (int) (Math.log(N) / Math.log(2));
            return result;
        }

        // find first element in the arr that is equal to the x. 
        // If x is not present in arr then it will return first element that is greater than x
        // It return arr.size() if all element are smaller than x
        public int lowerBound(int[] arr, int x) {
            int low = 0, high = arr.length, mid = -1;

            while (low < high) {
                mid = (low + high) / 2;

                if (arr[mid] >= x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }

        // find first element in the arr that is greater than x. 
        // It return arr.size() if all element are smaller than x
        public int upperBound(int[] arr, int x) {
            int low = 0, high = arr.length, mid = -1;

            while (low < high) {
                mid = (low + high) / 2;

                if (arr[mid] > x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }

    }

}