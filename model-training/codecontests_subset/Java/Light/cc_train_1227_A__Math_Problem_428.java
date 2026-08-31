
import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = in.nextInt();
        while (T-- > 0){
           int n = in.nextInt();
           int L = (int)-2e9;
           int R = (int)2e9;
            for (int i = 0; i < n; i++) {
                L = max(L,in.nextInt());
                R = min(R,in.nextInt());
            }
            out.println(max(L-R,0));
        }
        out.close();
    }
}
class event implements Comparable<event>{
    int x, T;

    public event(int x, int t) {
        this.x = x;
        T = t;
    }

    @Override
    public int compareTo(event event) {
        return x != event.x ? Integer.compare(x,event.x) : Integer.compare(T,event.T);
    }
}