import java.io.*;
import java.time.temporal.ValueRange;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");

    public static int nextInt() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static String next() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public static long nextLong() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
int a =nextInt();
        char[]b=next().toCharArray();
        TreeMap<String,Integer>tm=new TreeMap<>();
        for (int i = 0; i <a-1 ; i++) {
            String u ="";
            u+=b[i];
            u+=b[i+1];
            if(!tm.containsKey(u)){
                tm.put(u,1);
            }
            else{
                tm.put(u,tm.get(u)+1);
            }
        }
        int max =Integer.MIN_VALUE;
        String max1 ="";
        for (String c: tm.keySet()) {
            if(tm.get(c)>max){
                max =tm.get(c);
                max1=c;
            }
        }
        pw.print(max1);
        pw.close();
    }
}