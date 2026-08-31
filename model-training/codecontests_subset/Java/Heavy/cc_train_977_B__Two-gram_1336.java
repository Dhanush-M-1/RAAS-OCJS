import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
public class rrr {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        String s = sc.next();
        char h[] = s.toCharArray();
        String ans = "";
        int max = 0;
        HashMap<String, Integer> b = new HashMap<>();
        for (int i = 1; i < h.length; i++) {
            String f = h[i - 1] + "" + h[i];
            if (b.containsKey(f)) {
                b.put(f, b.get(f) + 1);
            }else{
                b.put(f,1);
            }
            if (max < b.get(f)) {
                max = b.get(f);
                ans = f;
            }
        }
        pw.print(ans);
        pw.close();
    }
}