import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        int n = Integer.parseInt(input);
        String way = in.readLine();
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            if (way.charAt(i) == '*')
                for (int j = 1; j < n; j++) {
                    int s = 1;
                    ok = true;
                    while (ok && s<5 && i+j*s<n) {
                        if (way.charAt(i + j * s) == '*') s++;
                        else ok=false;
                    }
                    if (s<5) ok=false;
                    if (ok) break;
                }
            if (ok) break;
        }
        if (ok) System.out.print("yes");
        else System.out.print("no");
    }
}
