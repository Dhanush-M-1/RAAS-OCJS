import javafx.util.Pair;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by hapsi on 11.10.2016.
 */
public class Main {
    private static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;
        public FastScanner(InputStream inputStream){
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }
        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()){
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException ignored){}
            }
            return stringTokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    private static int binarySearch(int []a, int l, int r, int x){
        if (l >= r) return -(l+1);
        int m = (l + r) / 2;
        if (a[m] > x || (a[m] == x && m > 0 && a[m-1] == x))
            return binarySearch(a, l, m, x);
        else if (a[m] < x)
            return binarySearch(a, m + 1, r, x);
        return m;
    }

    private static int nextSearch2(long []a, int l, int r, long x){
        if (l >= r) {
            if (a.length == 1 && a[0] <= x) {
                return 0;
            }
            else if (l - 1 >= 0 && a[l-1] <= x) {
                return l - 1;
            }
            else if (l < a.length && a[l] <= x){
                return l;
            }
            else if(l + 1 < a.length && a[l+1] <= x) {
                return l+1;
            }
            else if (l >= a.length && a[a.length - 1] <= x) {
                return a.length - 1;
            }
            return -1;
        }
        int m = (l + r) / 2;
        if (a[m] > x)
            return nextSearch2(a, l, m, x);
        else if (a[m] < x)
            return nextSearch2(a, m + 1, r, x);
        return m;
    }

    private static int nextSearch(int []a, int l, int r, int x){
        if (l >= r) return l;
        int m = (l + r) / 2;
        if (a[m] > x)
            return nextSearch(a, l, m, x);
        else if (a[m] < x || (m < a.length - 1 && a[m+1] == x))
            return nextSearch(a, m + 1, r, x);
        return m + 1;
    }

    private static int nextSearch(LinkedList<Integer>a, int l, int r, int x){
        if (l >= r) return l;
        int m = (l + r) / 2;
        if (a.get(m) > x)
            return nextSearch(a, l, m, x);
        else if (a.get(m) < x || (m < a.size() - 1 && a.get(m+1) == x))
            return nextSearch(a, m + 1, r, x);
        return m + 1;
    }

    private static int nearestSearch(int []a, int l, int r, int x) {
        if (l >= r) {
            if (a.length == 1) {
                return 0;
            }
            else if (l >= a.length) {
                return a.length - 1;
            }
            else if (l-1 >= 0) {
                int d1 = Math.abs(a[l-1] - x);
                int d2 = Math.abs(a[l] - x);
                if (d1 <= d2) {
                    return l-1;
                }
                return l;
            }
            else {
                return l;
            }
        }
        int m = (l + r) / 2;
        if (a[m] > x || (a[m] == x && m > 0 && a[m-1] == x)) {
            return nearestSearch(a, l, m, x);
        }
        else if (a[m] < x) {
            return nearestSearch(a, m + 1, r, x);
        }
        return m;
    }

    private static int compareStringNumbers(String a, String b){
        if(a.length() > b.length()){
            return 1;
        }
        else if(a.length() < b.length()){
            return -1;
        }
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) > b.charAt(i)){
                return 1;
            }
            else if(a.charAt(i) < b.charAt(i)){
                return -1;
            }
        }
        return 0;
    }

    private static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }

    private static List<Integer> dfs(ArrayList<ArrayList<Integer>>a, boolean used[], int v) {
        used[v] = true;
        List<Integer>path = null;
        for (int i = 0; i < a.get(v).size(); i++) {
            if(!used[a.get(v).get(i)]) {
                if (path == null)
                    path = dfs(a, used, a.get(v).get(i));
                else
                    path.addAll(dfs(a, used, a.get(v).get(i)));
            }
        }
        if (path == null) path = new ArrayList<>(1);
        path.add(v);
        return path;
    }

    private static boolean next(int[]a){
        for(int i = a.length-1;i>0;i--){
            for(int j=i-1;j>=0;j--) {
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    Arrays.sort(a, j + 1, a.length);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter printer = new PrintWriter(System.out);
        //scanner = new FastScanner(new FileInputStream("input.txt"));
        //printer = new PrintWriter(new FileOutputStream("output.txt"));
        int n = scanner.nextInt();
        String s = scanner.next();
        Map<String, Integer>c = new HashMap<>();
        for(int i=1;i<s.length();i++){
            String d = s.charAt(i-1) + "" + s.charAt(i);
            c.put(d, c.getOrDefault(d,0) + 1);
        }
        int ansMax = Integer.MIN_VALUE;
        String ans = "";
        for (Map.Entry<String, Integer> d:c.entrySet()) {
            if(d.getValue()>ansMax){
                ansMax = d.getValue();
                ans = d.getKey();
            }
        }
        printer.println(ans);
        printer.close();
    }
}

