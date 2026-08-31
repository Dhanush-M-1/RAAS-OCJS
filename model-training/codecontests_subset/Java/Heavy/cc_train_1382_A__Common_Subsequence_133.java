/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codeforces {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        try{
            Scanner scn = new Scanner(System.in);
            int t, i, j, n, m,A,B;
            t = scn.nextInt();
            for (i = 0; i < t; i++) {
                n=scn.nextInt();
                m=scn.nextInt();
                ArrayList<Integer> a=new ArrayList<Integer>();
                ArrayList<Integer> b=new ArrayList<Integer>();
                for (j=0;j<n;j++)
                {
                    A=scn.nextInt();
                    a.add(A);
                }
                for (j=0;j<m;j++)
                {
                    B=scn.nextInt();
                    b.add(B);
                }
                Collections.sort(a);
                Collections.sort(b);
                int f=0;
                for (j=0;j<n;j++)
                {
                    if (b.contains(a.get(j)))
                    {
                        f=1;
                        break;
                    }
                }
                if (f==1)
                {
                    System.out.println("YES");
                    System.out.println(1+" "+a.get(j));
                }
                else {
                    System.out.println("NO");
                }

            }
        }
        catch (Exception e)
        {
            return;
        }
    }
}
