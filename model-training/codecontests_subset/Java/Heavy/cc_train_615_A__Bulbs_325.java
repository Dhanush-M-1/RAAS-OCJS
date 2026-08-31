import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Ques9 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            String[] s1 = in.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            for (int j=1; j<s1.length; j++) {
                set.add(Integer.parseInt(s1[j]));
            }
        }
        if (set.size()==m) {
            out.write("YES \n");
        }
        else {
            out.write("NO \n");
        }
        out.flush();
    }
}