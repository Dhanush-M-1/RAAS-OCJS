

import java.awt.Point;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class KingMoves {
    static Map<Integer, List<Point>> segments;
    static Set<Point> visited;
    static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
    public static void main(String[] args) {
        MyReader mr = new MyReader();
        int x0 = mr.nextInt();
        int y0 = mr.nextInt();
        int x1 = mr.nextInt();
        int y1 = mr.nextInt();

        Point start = new Point(x0,y0);
        Point end = new Point(x1,y1);

        int n = mr.nextInt();
        segments = new HashMap<>();
        visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int r= mr.nextInt();
            int a =mr.nextInt();
            int b= mr.nextInt();
            Point tmp = new Point(a,b);

            if(segments.containsKey(r)){
                segments.get(r).add(tmp);
            }
            else{
                List<Point> l = new ArrayList<>();
                l.add(tmp);
                segments.put(r,l);
            }
        }

        int res = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()){
            Queue<Point> nextGen = new LinkedList<>();
            while (!q.isEmpty()){
                Point curr = q.poll();
                if(curr.equals(end)){
                    System.out.println(res);
                    return;
                }

                for(int[] d: deltas){
                    int x = curr.x+d[0];
                    int y = curr.y + d[1];

                    if(valid(x,y)){
                        Point tmp = new Point(x,y);
                        visited.add(tmp);
                        nextGen.add(tmp);
                    }
                }
            }

            res++;
            q = nextGen;
        }

        System.out.println(-1);




    }

    private static boolean valid(int x, int y) {
        Point tmp = new Point(x,y);
        if(!visited.contains(tmp) && segments.containsKey(x)){
            for(Point p : segments.get(x)){
                if(p.x <= y && y <= p.y)return true;
            }
            return false;
        }

        return false;
    }

    static class MyReader {
        BufferedReader br;
        StringTokenizer st;

        MyReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
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
            String res = "";
            try {
                res = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return res;
        }

        Integer[] nextIntArray(int n) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }

            return arr;
        }

        Long[] nextLongArray(int n) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }

            return arr;
        }

        String[] nextStringArray(int n) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = next();
            }
            return arr;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}


