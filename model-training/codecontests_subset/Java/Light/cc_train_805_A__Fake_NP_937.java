import java.util.*;
import java.io.*;

public final class Main {

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        if(l == r){
            System.out.println(l);
            return;
        }

        pw.println(2);
        pw.close();
    }
}