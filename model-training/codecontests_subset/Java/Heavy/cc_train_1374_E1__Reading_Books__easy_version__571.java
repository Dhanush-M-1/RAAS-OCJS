import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        FastReader f = new FastReader();

        int n = f.nextInt();
        int k = f.nextInt();

        int[] alice = new int[n];
        int[] bob = new int[n];
        int[] both = new int[n];

        int cntA=0, cntB=0;
        int cntBoth = 0;
        while (n-- > 0) {
            int t = f.nextInt();
            int a = f.nextInt();
            int b = f.nextInt();
            boolean aB = a != 0;
            boolean bB = b != 0;
            if(!aB && !bB) {
                continue;
            } else if(aB && bB) {
                both[cntBoth] = t;
                cntBoth++;
            } else if(aB) {
                alice[cntA] = t;
                cntA++;
            } else {
                bob[cntB] = t;
                cntB++;
            }

        }

        if(cntA+cntBoth < k || cntB+cntBoth < k) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(alice,0,cntA);
        Arrays.sort(bob, 0, cntB);
        Arrays.sort(both,0,cntBoth);


        long ans = 0;
        int ansCnt = 0;
        int pointA = 0, pointB = 0, pointBoth = 0;


        while (ansCnt < k) {
            if((pointA >= cntA || pointB >= cntB) && pointBoth < cntBoth) {
                ans += both[pointBoth];
                pointBoth++;
            } else {
                if(pointA < cntA && pointB < cntB && (pointBoth >= cntBoth || alice[pointA] + bob[pointB] < both[pointBoth])) {
                    ans += alice[pointA] + bob[pointB];
                    pointA++;
                    pointB++;
                } else {
                    ans += both[pointBoth];
                    pointBoth++;
                }
            }
            ansCnt++;
        }



        System.out.println(ans);
    }








    //fast input reader
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}


