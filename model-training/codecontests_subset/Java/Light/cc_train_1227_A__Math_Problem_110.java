import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Day9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        for(int q = 0; q < t; ++q){
            int n = Integer.parseInt(reader.readLine());
            ArrayList<Integer> s = new ArrayList<>();
            ArrayList<Integer> f = new ArrayList<>();
            for(int i =0; i < n; ++i){
                StringTokenizer st = new StringTokenizer(reader.readLine());
                s.add(Integer.parseInt(st.nextToken()));
                f.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(s);
            Collections.sort(f);
            writer.println(Math.max(0, s.get(s.size() - 1) - f.get(0)));
        }
        writer.close();
    }
}