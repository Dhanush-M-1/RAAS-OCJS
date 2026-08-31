//
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Main { 
  
    static BufferedReader in;
    static String file = "../in";
    static int test = 10; // 0 for local testing, 1 for std input
    static int inf = 1_000_000;

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}
/***********************************************************************/
/***********************************************************************/
/***********************************************************************/
/***********************************************************************/
        new Main().e();
    }

    static String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    static int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }
    

    void f() throws Exception
    {
        String[] sp = in.readLine().split(" ");
        int n = Integer.valueOf(sp[0]),
            d = Integer.valueOf(sp[1]),
            a = Integer.valueOf(sp[2]);

        int[][] ary = new int[n][2];

        int bound = 0;

        for(int i = 0; i < n; i++) {
            sp = in.readLine().split(" ");
            ary[i][0] = Integer.valueOf(sp[0]);
            ary[i][1] = Integer.valueOf(sp[1]);
            bound = Math.max(bound, ary[i][0]);
        }
        
        Arrays.sort(ary, (u, v)->(u[0] - v[0]));

        // SegmentTree root = new SegmentTree(0, ary[n - 1][0]);   //1_000_000_010);
        Queue<int[]> q = new PriorityQueue<>((u, v)->(u[0] - v[0]));
        long sum = 0;
        long re = 0;
        for(int i = 0; i < n; i++)
        {
            

            // for(int[] qq : q) System.out.println("current q.." + Arrays.toString(qq));
            
            // while(!q.isEmpty() && q.peek()[0] < ary[i][0]) q.poll();
            // long q = root.get(ary[i][0]);
            // System.out.printf("%d %d\n", ary[i][0], q);
            int maxd = ary[i][0] + 2 * d;
            while(!q.isEmpty() && q.peek()[0] <= ary[i][0] ) sum += q.poll()[1];
            // System.out.println("sum = .." + sum);
            ary[i][1] -= sum * a;

            // System.out.printf("current ary.. %s\n", Arrays.toString(ary[i]));
            if(ary[i][1] <= 0) continue;
            // for(int[] elm : ary)
            
            
            int op = ary[i][1] / a;
            if(ary[i][1] % a > 0) op++;
            re += op;
            q.offer(new int[]{ary[i][0], op});
            q.offer(new int[]{maxd + 1, -op});
        }

        System.out.println(re);
    }

    void e2(int n, int k)
    {
        for(int i = 0; i <= n; i++)
        {
            int a = i;
            int c = 0;
            while(a > 0)
            {
                if(a % 10 != 0) c++;
                a /= 10;
            }
            if(c == k) System.out.println(i);
        }
    }

    long ehelper(String str, int k)
    {
        int idx = 0;
        while(str.charAt(idx) == '0') idx++;
        str = str.substring(idx);
        char[] chs = str.toCharArray();
        int n = chs.length;
        if(n < k)
        {
            // System.out.println(0);
            return 0;
        }
        long sum = 0;

        if(k == 1)
        {
            sum += chs[0] - '0';
            sum += (n - 1) * 9;
        }
        if(k == 2)
        {
            int val = chs[0] - '0';
            sum += (n - 1) * (n - 2) / 2 * 81;
            for(int i = 1; i < val; i++)
            {
                sum += (n - 1) * 9;
            }
            for(int i = 1; i < n; i++) {
                if(chs[i] != '0')
                {
                    sum += chs[i] - '0';
                    sum += 9 * (n - i - 1);
                    break;
                }
            }
        }
        if(k == 3)
        {
            int val = chs[0] - '0';
            sum += (n - 1) * (n - 2) * (n - 3) / 6 * 729;
            for(int i = 1; i < val; i++)
            {
                sum += (n - 1) * (n - 2) / 2 * 81;
            }
            // System.out.println("..." +sum);
            sum += ehelper(str.substring(1), k - 1);
        }
        
        return sum;
    }


    void e() throws Exception
    {
        String str = in.readLine();
        int k = readInt();
        
        // e2(Integer.valueOf(str), k);
        System.out.println(ehelper(str, k));
    }

    long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    void d() throws Exception
    {
        String[] sp = split();
        int n = Integer.valueOf(sp[0]),
            k = Integer.valueOf(sp[1]);
        sp = split();

        double[] db = new double[n];
        for(int i = 0; i < n; i++)
        {
            int v = Integer.valueOf(sp[i]);
            int sum = (1 + v) * v / 2;
            double avg = 1.0 * sum / v;
            db[i] = avg;
        }

        // every k window
        double maxi = 0.0;
        double runsum = 0.0;

        for(int i = 0; i < n; i++)
        {
            runsum += db[i];
            if(i >= k - 1)
            {
                if(i >= k) runsum -= db[i - k];
                maxi = Math.max(maxi, runsum);
            }
        }
        System.out.println(maxi);

    }
    
    boolean satisfy(int a, int b)
    {
        String s1 = String.valueOf(a),
                s2 = String.valueOf(b);
        int m = s1.length(), n = s2.length();
        if(s1.charAt(0) == s2.charAt(n - 1) && 
            s1.charAt(m - 1) == s2.charAt(0)) return true;
        return false;
    }

    void c() throws Exception
    {
        int n = readInt();
        String[] sp = split();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            set.add(Integer.valueOf(sp[i]));
        }
        if(set.size() == n) System.out.println("YES");
        else System.out.println("NO");
    }

    void b() throws Exception
    {
        String str = in.readLine();
        char[] c = str.toCharArray();
        Arrays.fill(c, 'x');
        System.out.println(String.valueOf(c));
    }

    void a() throws Exception
    {
        String[] sp = split();
        String c1 = sp[0], c2 = sp[1];
        sp = split();
        int a = Integer.valueOf(sp[0]),
            b = Integer.valueOf(sp[1]);
        String u = in.readLine();
        if(c1.equals(u)) a--;
        if(c2.equals(u)) b--;
        System.out.printf("%d %d", a, b);
    }
}