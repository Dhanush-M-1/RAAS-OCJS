import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import static java.lang.Math.*;

public class ProblemD {
    BufferedReader rd;

    ProblemD() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() throws IOException {
        int p = intarr()[2];
        NavigableSet<Integer> a = set(intarr());
        int n = a.size();
        NavigableSet<Integer> b = set(intarr());
        int k = b.size();

        int from = 0;
        long best = Long.MAX_VALUE;
        for(Integer first: b) {
            int left = k-from;
            if(left < n) {
                break;
            }
            long time = 0;
            Iterator<Integer> it = a.iterator();
            for(Integer cur: b.tailSet(first)) {
                if(!it.hasNext()) {
                    break;
                }
                int person = it.next();
                time = max(time, abs(person - cur) + abs(cur - p));
            }
            best = min(best, time);
            from++;
        }
        out(best);
    }

    private NavigableSet<Integer> set(int[] a) {
        NavigableSet<Integer> s = new TreeSet<>();
        for(int x: a) {
            s.add(x);
        }
        return s;
    }

    private int[] intarr() throws IOException {
        return intarr(rd.readLine());
    }

    private int[] intarr(String s) {
        String[] q = split(s);
        int n = q.length;
        int[] a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(q[i]);
        }
        return a;
    }

    private String[] split(String s) {
        if(s == null) {
            return new String[0];
        }
        int n = s.length();
        int start = -1;
        int end = 0;
        int sp = 0;
        boolean lastWhitespace = true;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(isWhitespace(c)) {
                lastWhitespace = true;
            } else {
                if(lastWhitespace) {
                    sp++;
                }
                if(start == -1) {
                    start = i;
                }
                end = i;
                lastWhitespace = false;
            }
        }
        if(start == -1) {
            return new String[0];
        }
        String[] res = new String[sp];
        int last = start;
        int x = 0;
        lastWhitespace = true;
        for(int i=start;i<=end;i++) {
            char c = s.charAt(i);
            boolean w = isWhitespace(c);
            if(w && !lastWhitespace) {
                res[x++] = s.substring(last,i);
            } else if(!w && lastWhitespace) {
                last = i;
            }
            lastWhitespace = w;
        }
        res[x] = s.substring(last,end+1);
        return res;
    }

    private boolean isWhitespace(char c) {
        return c==' ' || c=='\t';
    }

    private static void out(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        new ProblemD();
    }
}
