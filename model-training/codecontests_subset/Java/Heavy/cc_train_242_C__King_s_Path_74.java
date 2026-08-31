/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.text.*;

public class cf242c_bfs_dfs {

    static BufferedReader br;
    static Scanner sc;
    static PrintWriter out;

    public static void initA() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new FileReader("input.txt"));
            sc = new Scanner(System.in);
            //out = new PrintWriter("output.txt");
            out = new PrintWriter(System.out);
        } catch (Exception e) {
        }
    }

    public static void initB() {
        try {

            br = new BufferedReader(new FileReader("input.txt"));
            sc = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");

        } catch (Exception e) {
        }
    }

    public static String getString() {
        try {
            return br.readLine();
        } catch (Exception e) {
        }
        return "";
    }

    public static Integer getInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
        }
        return 0;
    }

    public static Integer[] getIntArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            Integer temp2[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = Integer.parseInt(temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static Long[] getLongArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            Long temp2[] = new Long[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = Long.parseLong(temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static String[] getStringArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            String temp2[] = new String[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = (temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static int getMax(Integer[] ar) {
        int t = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > t) {
                t = ar[i];
            }
        }
        return t;
    }

    public static void print(Object a) {
        out.println(a);
    }

    public static int nextInt() {
        return sc.nextInt();
    }

    public static double nextDouble() {
        return sc.nextDouble();
    }

    public static void main(String[] ar) {
        initA();
        solve();
        out.flush();
    }
    static HashMap<Integer, ArrayList<Integer[]>> available = new HashMap<Integer, ArrayList<Integer[]>>();
    static HashMap<Integer, HashSet<Integer>> sdh = new HashMap<Integer, HashSet<Integer>>();

    public static void solve() {
        Integer sad[] = getIntArr();

        point start = new point(sad[0], sad[1], 0);
        
        int x_fin = sad[2];
        int y_fin = sad[3];

        if (sad[0] - sad[2] == 0 && sad[1] - sad[3] == 0) {
            print(0);
            return;
        }

        int dsa = getInt();



        for (int i = 0; i < dsa; i++) {
            sad = getIntArr();

            int row = sad[0];
            Integer s[] = {sad[1], sad[2]};
            if (available.containsKey(row)) {
                available.get(row).add(s);
            } else {
                ArrayList<Integer[]> init = new ArrayList<Integer[]>();
                init.add(s);
                available.put(row, init);
            }
        }

        //ArrayList<point> jalanku = new ArrayList<point>();
        Queue<point> jalanku = new ArrayDeque<point>();


        jalanku.add(start);
        HashSet<Integer> inis = new HashSet<Integer>();
        inis.add(start.y);
        sdh.put(start.x, inis);
        /*
        for (int is = 0; is < jalanku.size(); is++) {
            ArrayList<point> cabang = jalanku.get(is).getCabang();

         * 
         */
        for(;jalanku.size()>0;){
            ArrayList<point> cabang = jalanku.remove().getCabang();
            for (point p : cabang) {
                jalanku.add(p);
                //print("AKU JALAN KE " + p.x + "," + p.y + " dgn jarak " + (is + 1));
                if (p.x == x_fin && p.y == y_fin) {
                    print(p.d);
                    return;
                }
            }

        }
        for (point p : jalanku) {
            //print("JALANKU = " + p.x + " " + p.y);
        }
        print(-1);


    }

    private static class point {

        int x, y, d;

        point(int a, int b, int d) {
            x = a;
            y = b;
            this.d=d;
        }
        void hihi(int a, int b, ArrayList<point> arl){
            if (isAvailable(a, b)) {
                if (!sdh.containsKey(a)) {
                    HashSet<Integer> ini = new HashSet<Integer>();
                    ini.add(b);
                    sdh.put(a, ini);
                    arl.add(new point(a, b, d+1));
                }
                if (sdh.containsKey(a) && !sdh.get(a).contains(b)) {
                    sdh.get(a).add(b);
                    arl.add(new point(a, b, d+1));
                }

            }
        }

        ArrayList<point> getCabang() {
            ArrayList<point> temp = new ArrayList<point>();
          
            hihi(x-1,y-1, temp);
            hihi(x-1,y, temp);
            hihi(x-1,y+1, temp);
            hihi(x,y-1, temp);
            hihi(x,y+1, temp);
            hihi(x+1,y-1, temp);
            hihi(x+1,y, temp);
            hihi(x+1,y+1, temp);
            return temp;
        }

        boolean isAvailable(int x, int y) {
            if (available.containsKey(x)) {
                for (Integer[] b : available.get(x)) {
                    if (y >= b[0] && y <= b[1]) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }
}
