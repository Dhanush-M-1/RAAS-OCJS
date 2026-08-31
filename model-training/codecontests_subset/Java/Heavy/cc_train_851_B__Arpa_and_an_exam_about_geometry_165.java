import java.util.*;
import java.io.*;
public class Maximus {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());

        if((ax - bx)*1L*(ax - bx) + (ay - by)*1L*(ay - by) != (bx - cx)*1L*(bx - cx) + (by - cy)*1L*(by - cy) ||
                (ax - cx)*1L*(by - ay)  == (ax - bx)*1L*(cy - ay)){
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }
}