import java.io.*;
import java.util.*;
import java.math.*;

public class E2 {
    static final boolean RUN_TIMING = false;
    static char[] inputBuffer = new char[1 << 20];
    static PushbackReader in = new PushbackReader(new BufferedReader(new InputStreamReader(System.in)), 1 << 20);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public void go() throws IOException {
        // in = new PushbackReader(new BufferedReader(new FileReader(new File("test.txt"))), 1 << 20);
        // out = new PrintWriter(new FileWriter(new File("output.txt")));
        int n = ipar();
        int m = ipar();
        int k = ipar();
        ArrayList<ArrayList<int[]>> books = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            books.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int t = ipar();
            int a = ipar();
            int b = ipar();
            books.get(a*2+b).add(new int[]{t, i});
        }
        for (int i = 0; i < 4; i++) {
            Collections.sort(books.get(i), this::compare);
        }
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < k; i++) {
            if (index1+1 < books.get(1).size()) {
                index1++;
                sum1 += books.get(1).get(index1)[0];
            }
            if (index2+1 < books.get(2).size()) {
                index2++;
                sum2 += books.get(2).get(index2)[0];
            }
        }
        PriorityQueue<int[]> candidates = new PriorityQueue<>(this::compare);
        for (int i = k; i < books.get(1).size(); i++) {
            candidates.add(books.get(1).get(i));
        }
        for (int i = k; i < books.get(2).size(); i++) {
            candidates.add(books.get(2).get(i));
        }
        for (int i = 0; i < books.get(0).size(); i++) {
            candidates.add(books.get(0).get(i));
        }
        TreeSet<int[]> free = new TreeSet<>(this::compare);
        int freeSum = 0;
        while (index1+index2+2+free.size() < m && !candidates.isEmpty()) {
            int[] add = candidates.remove();
            free.add(add);
            freeSum += add[0];
        }
        while (index1+index2+2+free.size() > m && !free.isEmpty()) {
            int[] rem = free.last();
            free.remove(rem);
            freeSum -= rem[0];
            candidates.add(rem);
        }
        // out.printf("%d %d %d %d  :  %d %d %d%n", sum1, sum2, sum3, freeSum, index1, index2, -1);
        int best = Integer.MAX_VALUE;
        int bestIndex = -2;
        if (index1+index2+2+free.size() == m && index1+1 == k && index2+1 == k) {
            best = sum1+sum2+freeSum;
            bestIndex = -1;
        }
        int index3 = -1;
        while (index3+1 < books.get(3).size()) {
            index3++;
            sum3 += books.get(3).get(index3)[0];
            if (index1 >= 0 && index1+index3+2 > k) {
                sum1 -= books.get(1).get(index1)[0];
                candidates.add(books.get(1).get(index1));
                index1--;
                if (!free.isEmpty()) {
                    int[] rem = free.last();
                    free.remove(rem);
                    freeSum -= rem[0];
                    candidates.add(rem);
                    int[] add = candidates.remove();
                    free.add(add);
                    freeSum += add[0];
                }
            }
            if (index2 >= 0 && index2+index3+2 > k) {
                sum2 -= books.get(2).get(index2)[0];
                candidates.add(books.get(2).get(index2));
                index2--;
                if (!free.isEmpty()) {
                    int[] rem = free.last();
                    free.remove(rem);
                    freeSum -= rem[0];
                    candidates.add(rem);
                    int[] add = candidates.remove();
                    free.add(add);
                    freeSum += add[0];
                }
            }
            while (index1+index2+index3+3+free.size() < m && !candidates.isEmpty()) {
                int[] add = candidates.remove();
                free.add(add);
                freeSum += add[0];
            }
            while (index1+index2+index3+3+free.size() > m && !free.isEmpty()) {
                int[] rem = free.last();
                free.remove(rem);
                freeSum -= rem[0];
                candidates.add(rem);
            }
            if (index1+index2+index3+3+free.size() == m && index1+index3+2 >= k && index2+index3+2 >= k && sum1+sum2+sum3+freeSum < best) {
                best = sum1+sum2+sum3+freeSum;
                bestIndex = index3;
            }
            // out.printf("%d %d %d %d  :  %d %d %d%n", sum1, sum2, sum3, freeSum, index1, index2, index3);
        }
        // out.printf("%d %d%n", best, bestIndex);
        sum1 = sum2 = sum3 = 0;
        index1 = index2 = -1;
        for (int i = 0; i < k; i++) {
            if (index1+1 < books.get(1).size()) {
                index1++;
                sum1 += books.get(1).get(index1)[0];
            }
            if (index2+1 < books.get(2).size()) {
                index2++;
                sum2 += books.get(2).get(index2)[0];
            }
        }
        candidates.clear();
        for (int i = k; i < books.get(1).size(); i++) {
            candidates.add(books.get(1).get(i));
        }
        for (int i = k; i < books.get(2).size(); i++) {
            candidates.add(books.get(2).get(i));
        }
        for (int i = 0; i < books.get(0).size(); i++) {
            candidates.add(books.get(0).get(i));
        }
        free.clear();
        freeSum = 0;
        while (index1+index2+2+free.size() < m && !candidates.isEmpty()) {
            int[] add = candidates.remove();
            free.add(add);
            freeSum += add[0];
        }
        while (index1+index2+2+free.size() > m && !free.isEmpty()) {
            int[] rem = free.last();
            free.remove(rem);
            freeSum -= rem[0];
            candidates.add(rem);
        }
        // out.printf("%d %d %d %d  :  %d %d %d%n", sum1, sum2, sum3, freeSum, index1, index2, index3);
        index3 = -1;
        while (index3+1 <= bestIndex) {
            index3++;
            sum3 += books.get(3).get(index3)[0];
            if (index1 >= 0 && index1+index3+2 > k) {
                sum1 -= books.get(1).get(index1)[0];
                candidates.add(books.get(1).get(index1));
                index1--;
                if (!free.isEmpty()) {
                    int[] rem = free.last();
                    free.remove(rem);
                    freeSum -= rem[0];
                    candidates.add(rem);
                    int[] add = candidates.remove();
                    free.add(add);
                    freeSum += add[0];
                }
            }
            if (index2 >= 0 && index2+index3+2 > k) {
                sum2 -= books.get(2).get(index2)[0];
                candidates.add(books.get(2).get(index2));
                index2--;
                if (!free.isEmpty()) {
                    int[] rem = free.last();
                    free.remove(rem);
                    freeSum -= rem[0];
                    candidates.add(rem);
                    int[] add = candidates.remove();
                    free.add(add);
                    freeSum += add[0];
                }
            }
            while (index1+index2+index3+3+free.size() < m && !candidates.isEmpty()) {
                int[] add = candidates.remove();
                free.add(add);
                freeSum += add[0];
            }
            while (index1+index2+index3+3+free.size() > m && !free.isEmpty()) {
                int[] rem = free.last();
                free.remove(rem);
                freeSum -= rem[0];
                candidates.add(rem);
            }
            // out.printf("%d %d %d %d  :  %d %d %d%n", sum1, sum2, sum3, freeSum, index1, index2, index3);
        }
        if (best == Integer.MAX_VALUE) {
            out.println(-1);
            return;
        }
        out.println(best);
        for (int i = 0; i <= index1; i++) {
            out.print(books.get(1).get(i)[1]+1);
            out.print(" ");
        }
        for (int i = 0; i <= index2; i++) {
            out.print(books.get(2).get(i)[1]+1);
            out.print(" ");
        }
        for (int i = 0; i <= index3; i++) {
            out.print(books.get(3).get(i)[1]+1);
            out.print(" ");
        }
        for (int[] f : free) {
            out.print(f[1]+1);
            out.print(" ");
        }
        out.println();
    }

    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return a[1] - b[1];
        }
        return a[0] - b[0];
    }

    public int ipar() throws IOException {
        return Integer.parseInt(spar());
    }

    public int[] iapar(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ipar();
        }
        return arr;
    }

    public long lpar() throws IOException {
        return Long.parseLong(spar());
    }

    public long[] lapar(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = lpar();
        }
        return arr;
    }

    public double dpar() throws IOException {
        return Double.parseDouble(spar());
    }

    public String spar() throws IOException {
        int len = 0;
        int c;
        do {
            c = in.read();
        } while (Character.isWhitespace(c) && c != -1);
        if (c == -1) {
            throw new NoSuchElementException("Reached EOF");
        }
        do {
            inputBuffer[len] = (char)c;
            len++;
            c = in.read();
        } while (!Character.isWhitespace(c) && c != -1);
        while (c != '\n' && Character.isWhitespace(c) && c != -1) {
            c = in.read();
        }
        if (c != -1 && c != '\n') {
            in.unread(c);
        }
        return new String(inputBuffer, 0, len);
    }

    public String linepar() throws IOException {
        int len = 0;
        int c;
        while ((c = in.read()) != '\n' && c != -1) {
            if (c == '\r') {
                continue;
            }
            inputBuffer[len] = (char)c;
            len++;
        }
        return new String(inputBuffer, 0, len);
    }

    public boolean haspar() throws IOException {
        String line = linepar();
        if (line.isEmpty()) {
            return false;
        }
        in.unread('\n');
        in.unread(line.toCharArray());
        return true;
    }

    public static void main(String[] args) throws IOException {
        long time = 0;
        time -= System.nanoTime();
        new E2().go();
        time += System.nanoTime();
        if (RUN_TIMING) {
            System.out.printf("%.3f ms%n", time / 1000000.0);
        }
        out.flush();
        in.close();
    }
}
