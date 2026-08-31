/**
 * Created by Aminul on 8/11/2018.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class CF425D_5 {

    public static void main(String[] args)throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int N = (int)1e5;

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(), y = in.nextInt();
            mapX.putIfAbsent(x, new HashSet<>());
            mapX.get(x).add(y);
        }


        int sqrt = (int) Math.sqrt(n);
        long ans = solveX(mapX, N, sqrt);
        for(int i : mapX.keySet()){
            for(int y : mapX.get(i)){
                mapY.putIfAbsent(y, new HashSet<>());
                mapY.get(y).add(i);
            }
        }

        ans += solveY(mapY, N, n);

        pw.println(ans);


        pw.close();
    }


    static HashMap<Integer, HashSet<Integer>> mapX = new HashMap<>(), mapY = new HashMap<>();
    static HashSet<Long> set = new HashSet<>();

    static boolean contains(int x, int y){
        return mapX.containsKey(x) && mapX.get(x).contains(y);
    }

    static boolean contains2(int x, int y){
        return mapY.containsKey(y) && mapY.get(y).contains(x);
    }

    static long solveX(HashMap<Integer, HashSet<Integer>> map, int N, int SQRT){
        long ans = 0;
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > SQRT) continue;
            int a[] = setToArray(entry.getValue());
            //Arrays.sort(a);
            int i = entry.getKey();
            for (int j = 0; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    int y1 = a[j], y2 = a[k];
                    int d = y2 - y1;
                    if (contains(i - d, y1) && contains(i - d, y2)) ans++;
                    if (contains(i + d, y1) && contains(i + d, y2)) ans++;
                }
            }
            map.get(i).clear();
        }
        return ans;
    }

    static long solveY(HashMap<Integer, HashSet<Integer>> map, int N, int SQRT){
        long ans = 0;
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > SQRT) continue;
            int a[] = setToArray(entry.getValue());
            int i = entry.getKey();
           // Arrays.sort(a);
            for(int j = 0; j < a.length; j++){
                for(int k = j+1; k < a.length; k++){
                    int x1 = a[j], x2 = a[k];
                    int d = x2 - x1;
                    if(contains2(x1, i-d) && contains2(x2, i-d)) ans++;
                    if(contains2(x1, i+d) && contains2(x2, i+d)) ans++;
                }
            }
            map.get(i).clear();
        }
        return ans;
    }

    static int [] setToArray(HashSet<Integer> set){
        int a[] = new int[set.size()], idx = 0;
        for(int i : set) a[idx++] = i;
        return a;
    }

    static int[] listToArr(List<Integer> list){
        return list.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
    }

    static long getHash(long x, long y){
        return (x << 30) | y;
    }

    static <T>List<T>[] genList(int n){
        List<T> list[] = new List[n];
        for(int i = 0; i < n; i++) list[i] = new ArrayList<T>();
        return list;
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;
        static final int ints[] = new int[128];

        public FastReader(InputStream is){
            for(int i='0';i<='9';i++) ints[i]=i-'0';
            this.is = is;
        }

        public int readByte(){
            if(lenbuf == -1)throw new InputMismatchException();
            if(ptrbuf >= lenbuf){
                ptrbuf = 0;
                try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
                if(lenbuf <= 0)return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
        public int skip() {
            int b;
            while((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next(){
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt(){
            int num = 0, b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
       /* public char nextChar() {
            return (char)skip();
        }*/

        public char[] next(int n){
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while(p < n && !(isSpaceChar(b))){
                buf[p++] = (char)b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        /*private char buff[] = new char[1005];
        public char[] nextCharArray(){
            int b = skip(), p = 0;
            while(!(isSpaceChar(b))){
                buff[p++] = (char)b;
                b = readByte();
            }
            return Arrays.copyOf(buff, p);
        }*/
    }
}