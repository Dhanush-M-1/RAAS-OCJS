import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        IO io = new IO() ;
        int l = io.getInt(), r = io.getInt(), n = l - r + 1 ;
        if(l == r && l % 2 != 0) {
            System.out.println(l);
            return;
        }
        int ts = l % 2 == 0 ? l: l - l % 2 + 2, te = r - r % 2 ;
        int ths = l % 3 == 0 ? l: l - l % 3 + 3, the = r - r % 3 ;
        int n2 = (te - ts) / 2 + 1, n3 = (the - ths) / 3 + 1 ;

//        Utils.print(ts, te, ths, the) ;
        System.out.println(n2 > n3 ? 2: 3) ;
    }
}

class Utils {

    public static void swap(List<Integer> ls, int i, int j){
        int temp = ls.get(i) ;
        ls.set(i, ls.get(j)) ;
        ls.set(j, temp) ;
    }

    public static long gcd(long a, long b){
        if(a < b)
            return gcd(b, a) ;
        else if(a == b || b == 0)
            return a ;
        else{
            return gcd(b, a % b) ;
        }
    }

    public static long subSum(long[] pre, int l, int h){
        return l == 0 ? pre[h]: pre[h] - pre[l - 1] ;
    }

    public static class Pair implements Comparable<Pair>{
        public int m, s ;

        public Pair(int a, int b) {
            this.m = a;
            this.s = b;
        }

        @Override
        public int compareTo(Pair o) {
            return m - o.m ;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "m=" + m +
                    ", s=" + s +
                    '}';
        }
    }

    public static void ifPrint(boolean test, Object ifValue, Object elseValue){
        System.out.println(test ? ifValue: elseValue) ;
    }

    public static void print(Character delim, Object... a){
        List<String> top = new ArrayList<>() ;
        for(Object aa: a)
            top.add(aa == null ? "null": aa.toString()) ;
        System.out.println(join(top, delim.toString())) ;
    }

    public static void print(Object... a){
        print(' ', a) ;
    }

    public static  <T extends Comparable<T>> int lowerBound(T[] arr, int l, int h, T key){
        while(l < h){
            int mid = (l + h) / 2 ;
            if(arr[mid].compareTo(key) < 0)
                l = mid + 1 ;
            else
                h = mid ;
        }
        return arr[l].compareTo(key) >= 0 ? l: -1 ;
    }

    public static <T extends Comparable<T>> int upperBound(T[] arr, int l, int h, T key){
        while(l < h){
            int mid = (l + h) / 2 ;
            if(arr[mid].compareTo(key) < 0)
                l = mid + 1 ;
            else if(arr[mid].compareTo(key) == 0)
                l = mid ;
            else
                h = mid ;
            if(h == l + 1)
                break ;
        }
        return arr[l].compareTo(key) >= 0 ? l: -1 ;
    }

    public static class IndexedElement<T> {
        int idx;
        T val;

        public IndexedElement(int idx, T val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static <T> ArrayList<IndexedElement<T>> getIndexedArray(ArrayList<T> ip) {
        ArrayList<IndexedElement<T>> op = new ArrayList<>();
        for (int i = 0; i < ip.size(); i++) {
            op.add(new IndexedElement<>(i, ip.get(i)));
        }
        return op;
    }

    public static <T> String join(List<T> ls) {
        return join(ls, " ") ;
    }

    public static <T> String join(List<T> ls, String delim) {
        StringJoiner sj = new StringJoiner(delim);
        for (T a : ls)
            sj.add(a.toString());
        return sj.toString();
    }

    public static <T> void print2DArray(List<List<T>> mat) {
        for (List<T> m : mat) {
            System.out.println("{ " + join(m, ", ") + " }");
        }
    }

    public static  <T> void reverseArrray(T[] arr, int l, int h){
        while(l < h){
            T temp = arr[l] ;
            arr[l] = arr[h] ;
            arr[h] = temp ;
            l++ ;
            h-- ;
        }
    }
}

class IO {
    private BufferedReader br = null;
    private StringTokenizer st = null;

    public IO() {
        this(System.in);
    }

    public IO(InputStream is) {
        this.br = new BufferedReader(new InputStreamReader(is));
    }

    public List<String> getStringArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        if (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            res.add(st.nextToken());
        }
        return res;
    }
    public String getString() throws IOException {
        List<String> res = this.getStringArray(1);
        return res.size() == 0 ? "" : res.get(0);
    }

    public List<Integer> getIntegerArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        List<String> res = getStringArray(n);
        return res.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
    public Integer getInt() throws IOException {
        List<Integer> res = this.getIntegerArray(1);
        return res.size() == 0 ? 0 : res.get(0);
    }

    public List<Long> getLongArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        List<String> res = getStringArray(n);
        return res.stream().map(Long::parseLong).collect(Collectors.toList());
    }
    public Long getLong() throws IOException {
        List<Long> res = this.getLongArray(1);
        return res.size() == 0 ? 0L : res.get(0);
    }

    public List<Double> getDoubleArray(int n) throws IOException {
        if (n == 0)
            return new ArrayList<>();
        List<String> res = getStringArray(n);
        return res.stream().map(Double::parseDouble).collect(Collectors.toList());
    }
    public Double getDouble() throws IOException {
        List<Double> res = this.getDoubleArray(1);
        return res.size() == 0 ? 0.0 : res.get(0);
    }
}