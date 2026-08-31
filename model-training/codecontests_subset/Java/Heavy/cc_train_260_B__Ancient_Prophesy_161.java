
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pttrung
 */
public class B {

    public static void main(String[] args) throws FileNotFoundException {
        int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        //     PrintWriter out = new PrintWriter(new FileOutputStream(new File("output.txt")));
        String line = in.next();
        StringBuilder builder = new StringBuilder();
        
        HashMap<String, Integer> count = new HashMap();
        for (int i = 9; i < line.length(); i++) {
           String val = line.substring(i - 9, i + 1);
           String []temp = val.split("-");
           if(temp.length != 3){
               continue;
           }else{
               if(temp[0].length() != 2){
                   continue;
               }else if(temp[1].length() != 2){
                   continue;
               }else if(temp[2].length() != 4){
                   continue;
               }
               int day = Integer.parseInt(temp[0]);
               int month =Integer.parseInt(temp[1]);
               int year = Integer.parseInt(temp[2]);
               if(month >= 1 && month <=12 && year >=2013 && year <= 2015){
                   int max = m[month - 1];
                   if(day > 0 && day <= max){
                     
                       if(!count.containsKey(val)){
                           count.put(val,1);
                       }else{
                           count.put(val,count.get(val) + 1);
                       }
                   }
               }
           }
           
        }
        int max = 0;
        String result = null;
        for(String key : count.keySet()){
            if(count.get(key) > max){
                max = count.get(key);
                result = key;
            }
        }
        out.println(result);
        out.close();
    }

    static class FT {

        int[] data;

        FT(int n) {
            data = new int[n];
        }

        void update(int index, int val) {
            // System.out.println("UPDATE INDEX " + index);
            while (index < data.length) {
                data[index] += val;
                index += index & (-index);

                //    System.out.println("NEXT " +index);
            }
        }

        int get(int index) {
            //  System.out.println("GET INDEX " + index);
            int result = 0;
            while (index > 0) {
                result += data[index];
                index -= index & (-index);
                // System.out.println("BACK " + index);
            }
            return result;
        }
    }

    public static double dist(Point a, Point b) {
        double val = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        return Math.sqrt(val);
    }

    public static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean nextPer(int[] data) {
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;
    }

    public static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val;
        } else {
            return val * val * a;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new FileReader(new File("input.txt")));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
