

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C242 {

    void solve(){
        int x0 = readInt();
        int y0 = readInt();
        int x1 = readInt();
        int y1 = readInt();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();

        int n =readInt();
        for(int i = 0;i<n;i++){
            int r = readInt();
            int a = readInt();
            int b = readInt();
            for(int j = a;j<=b;j++){
                set.add(r + " " + j);
            }
        }

        if(!set.contains(x0 + " " + y0) || !set.contains(x1 + " " + y1)){
            out.print(-1);
            return;
        }

        queue.add(x0);
        queue.add(y0);
        map.put((x0 + " " + y0), 0);

        int[] goX = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] goY = {-1, 0, 1, 1, 1, 0, -1, -1};

        while(!queue.isEmpty()){
            int x = queue.pollFirst();
            int y = queue.pollFirst();
            String s = x + " " + y;

            for(int i = 0;i<8;i++){
                int a = x + goX[i];
                int b = y + goY[i];
                String w = a + " " + b;
                if(set.contains(w) && !map.containsKey(w)){
                    map.put(w, map.get(s) + 1);
                    queue.addLast(a);
                    queue.addLast(b);
                }
            }
        }

        out.print(map.getOrDefault(x1 +" " + y1, -1));
    }

    public static void main(String[] args) {
        new C242().run();
    }

    void run(){
        init();
        solve();
        out.close();
    }

    BufferedReader in;
    PrintWriter out;

    StringTokenizer tok = new StringTokenizer("");

    void init(){
        in = new BufferedReader(new InputStreamReader(System.in));
        out  = new PrintWriter(System.out);
    }

    String readLine(){
        try{
            return in.readLine();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    String readString(){
        while(!tok.hasMoreTokens()){
            String nextLine = readLine();
            if(nextLine == null) return null;
            tok = new StringTokenizer(nextLine);
        }
        return tok.nextToken();
    }

    int readInt(){
        return Integer.parseInt(readString());
    }

    long readLong(){
        return Long.parseLong(readString());
    }

    double readDouble(){
        return Double.parseDouble(readString());
    }
}
