import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        new Solver().run(1);
    }
}

class Solver {

    private BufferedReader reader = null;
    private StringTokenizer st = null;

    private static final long INF = Long.MAX_VALUE;

    private int n, m, k;
    private int[] s, segStart, segFinish, mark, a;
    private int segmentsCnt, maxSegLen;

    private long ans = INF;

    public void run(int inputType) throws Exception {
        if (inputType == 0)
            reader = new BufferedReader(new FileReader("input.txt"));
        else
            reader = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        s = new int[m];
        mark = new int[n];
        a = new int[k + 1];
        segStart = new int[m];
        segFinish = new int[m];

        Arrays.fill(mark, -1);

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; ++i) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= k; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        reader.close();

        if (m > 0) {

            segStart[0] = s[0];
            segFinish[0] = -1;
            segmentsCnt = 1;
            mark[s[0]] = 0;
            maxSegLen = 0;
            for (int i = 1; i < m; ++i) {

                mark[s[i]] = segmentsCnt - 1;
                if (s[i] > s[i - 1] + 1) {

                    mark[s[i]] = segmentsCnt;
                    segFinish[segmentsCnt - 1] = s[i - 1];

                    maxSegLen = Math.max(maxSegLen, s[i - 1] - segStart[segmentsCnt - 1] + 1);

                    segStart[segmentsCnt] = s[i];
                    segFinish[segmentsCnt++] = -1;
                }
            }

            segFinish[segmentsCnt - 1] = s[m - 1];
            maxSegLen = Math.max(maxSegLen, s[m - 1] - segStart[segmentsCnt - 1] + 1);

            for (int i = maxSegLen + 1; i <= k; ++i) {

                long localAns = checkLamp(i);

                ans = Math.min(ans, localAns);
            }

        } else {

            for (int i = 1; i <= k; ++i) {
                long localAns = checkLamp(i);
                ans = Math.min(ans, localAns);
            }
        }

        ans = (ans == INF) ? -1 : ans;
        System.out.println(ans);
    }

    long checkLamp(int lamp) {

        boolean solutionExists = true;
        int base = -1;
        int rightmost = 0;
        long checkAns = 0L;
        while (rightmost < n) {

            if (mark[rightmost] == -1) {
                checkAns += a[lamp];
                base = rightmost;
                rightmost = base + lamp;
                continue;
            }

            if (segStart[mark[rightmost]] <= base + 1) {
                solutionExists = false;
                break;
            }

            base = segStart[mark[rightmost]] - 1;
            rightmost = base + lamp;
            checkAns += a[lamp];
        }

        if (!solutionExists)
            return INF;

        return checkAns;
    }
}
