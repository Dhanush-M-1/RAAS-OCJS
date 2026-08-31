import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P284B_CowsAndPokerGame {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        int i = 0;
        int a = 0;
        for (int ii=0; ii<n; ii++) {
            if (s.charAt(ii) == 'A') {
                a++;
            } else if (s.charAt(ii) == 'I') {
                i++;
            }
        }
        System.out.println(cnt(i,a));
    }
    
    public static int cnt(int i, int a) {
        if (i > 1) return 0;
        if (i == 1) return 1;
        return a;
    }
    
}