import java.util.*;

public class Check2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong();
        long k=sc.nextLong();
        long[] ar=new long[(int) (n+1)];
        for(int i=1;i<=n;i++){
            ar[i]=sc.nextLong();
        }
        long y=0;
        for(long j=k;j>=0;j--){
            long g=(1+8*j);
           // System.out.println(g);
            double y1=Math.sqrt(g);
            if(y1*y1==g){
                y=1+8*j;
              //  System.out.println(j);
                break;
            }
        }
        long n1= (long) ((-1+Math.sqrt(y))/2);
       // System.out.println(n1);
        long diff=k-(n1*(n1+1))/2;
       // System.out.println(diff);
        if(diff!=0){
            System.out.println(ar[(int) diff]);
        }else {
            System.out.println(ar[(int) n1]);
        }




    }

    public static void Mybfs(List<List<Integer>> lists, int source, int[] dist, boolean[] visited) {
        dist[source] = 0;
        // visited[source]=true;
        Queue<Integer> queue = new LinkedList<>();
        //Deque<Integer> deque=new ArrayList<>();

        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int source1 = queue.poll();

            for (Integer integer : lists.get(source1)) {
                if (dist[integer] > (dist[source1] + 1)) {
                    // visited[integer]=true;
                    queue.add(integer);
                    dist[integer] = Math.min(dist[integer], dist[source1] + 1);
                }

            }
        }

    }

    public static void bfs(int[][] ar, int i, int j, int n, int m, long[][] ans) {
        Queue<int[]> queue = new LinkedList<>();
        int[] ij = {i, j};
        queue.add(ij);
        ans[i][j] = 0;
        while (!queue.isEmpty()) {
            int[] ij1 = queue.poll();
            int i1 = ij1[0];
            int j1 = ij1[1];
            int a, b;
            a = i1 - 1;
            b = j1;
            if (a >= 0 && ar[a][b] == 0 && ans[a][b] > ans[i1][j1] + 1) {
                ans[a][b] = ans[i1][j1] + 1;
                int[] ij2 = {a, b};
                queue.add(ij2);
            }
            a = i1 + 1;
            b = j1;
            if (a < n && ar[a][b] == 0 && ans[a][b] > ans[i1][j1] + 1) {
                ans[a][b] = ans[i1][j1] + 1;
                int[] ij2 = {a, b};
                queue.add(ij2);
            }
            a = i1;
            b = j1 - 1;
            if (b >= 0 && ar[a][b] == 0 && ans[a][b] > ans[i1][j1] + 1) {
                ans[a][b] = ans[i1][j1] + 1;
                int[] ij2 = {a, b};
                queue.add(ij2);
            }
            a = i1;
            b = j1 + 1;
            if (b < m && ar[a][b] == 0 && ans[a][b] > ans[i1][j1] + 1) {
                ans[a][b] = ans[i1][j1] + 1;
                int[] ij2 = {a, b};
                queue.add(ij2);
            }

        }
        /*if(i<0||j<0||i>=n||j>=m){
              return Integer.MAX_VALUE;
        }
        if(ar[i][j]==1){
            return 0;
        }

        long ans1=Integer.MAX_VALUE;
        long ans2=Integer.MAX_VALUE;
        long ans3=Integer.MAX_VALUE;
        long ans4=Integer.MAX_VALUE;
        if(i<(n-1)){
            ans1=bfs(ar,i+1,j,n,m);
        }
        if(j<(m-1)){
            ans2=bfs(ar,i,j+1,n,m);
        }
        if(i>0){
            ans3=bfs(ar,i-1,j,n,m);
        }
        if(j>0){
            ans4=bfs(ar,i,j-1,n,m);
        }
        return 1+Math.min(Math.min(Math.min(ans1,ans2),ans3),ans4);*/

    }

    public static void dfs(boolean[] visited, long[] count, List<List<Integer>> lists, int num, int c) {
        visited[num] = true;
        count[c]++;
        for (Integer integer : lists.get(num)) {
            if (!visited[integer]) {
                dfs(visited, count, lists, integer, 1 - c);
            }
        }
    }

    /*public static int getAns(String a, String b, String[][] ans1, String[][] ans2, int l1, int l2, int[][] dp) {
        if (a != null && a.equals(b)) {
            return 0;
        }
        if (dp[l1][l2] != -1) {
            return dp[l1][l2];
        }
        int a1 = Integer.MAX_VALUE, a2 = Integer.MAX_VALUE, a3 = Integer.MAX_VALUE, a4 = Integer.MAX_VALUE;
        if (a != null && l1 >= 2 && ans1[1][l1] != null) {
            a1 = getAns(ans1[1][l1], b, ans1, ans2, l1 - 1, l2, dp);
        }
        //int a1=getAns(a.substring(1),b);
        if (a != null && l1 >= 1 && ans1[0][l1 - 1] != null) {
            a2 = getAns(ans1[0][l1 - 1], b, ans1, ans2, l1 - 1, l2, dp);
        }
        //int a2=getAns(a.substring(0,a.length()-1),b);
        if (b != null && l2 >= 2 && ans2[1][l2] != null) {
            a3 = getAns(a, ans2[1][l2], ans1, ans2, l1, l2 - 1, dp);
        }
        // int a3=getAns(a,b.substring(1));
        if (b != null && l2 >= 1 && ans2[0][l2 - 1] != null) {
            a4 = getAns(a, ans2[0][l2 - 1], ans1, ans2, l1, l2 - 1, dp);
        }
        // int a4=getAns(a,b.substring(0,b.length()-1));
        if (a1 != Integer.MAX_VALUE || a2 != Integer.MAX_VALUE || a3 != Integer.MAX_VALUE || a4 != Integer.MAX_VALUE) {
            dp[l1][l2] = 1 + (Math.min(a1, Math.min(a2, Math.min(a3, a4))));
        }
        return dp[l1][l2];


    }*/


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

    static int val(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    // Function to convert a
// number from given base
// 'b' to decimal
    static int toDeci(String str,
                      int base) {
        int len = str.length();
        int power = 1; // Initialize
        // power of base
        int num = 0; // Initialize result
        int i;

        // Decimal equivalent is
        // str[len-1]*1 + str[len-2] *
        // base + str[len-3]*(base^2) + ...
        for (i = len - 1; i >= 0; i--) {
            // A digit in input number
            // must be less than
            // number's base
            if (val(str.charAt(i)) >= base) {
                System.out.println("Invalid Number");
                return -1;
            }

            num += val(str.charAt(i)) * power;
            power = power * base;
        }

        return num;
    }
}