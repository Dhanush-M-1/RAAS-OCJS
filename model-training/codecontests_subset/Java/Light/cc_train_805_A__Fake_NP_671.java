
import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()),
            r = Integer.parseInt(st.nextToken());
        if (l == r) {
            System.out.println(l);
            return;
        }
        System.out.println(2);
    }
}
