import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine().toLowerCase();
        int M = Integer.parseInt(br.readLine());
        char[] s = new char[N.length()];
        for (int i = 0; i < N.length(); i++) {
            char a = N.charAt(i);
            if(a < M + 97)
                s[i] = (char) (a - 32);
            else
                s[i] = a;
        }
        System.out.println(new String(s));
    }
}