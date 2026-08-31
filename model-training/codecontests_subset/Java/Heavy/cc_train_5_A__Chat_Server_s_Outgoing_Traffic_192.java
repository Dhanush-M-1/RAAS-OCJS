import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;

public class Chat {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean b = true;
        int n = 0;
        int bytes = 0;
        int i = 1;
        while(b) {
            //try {
            try {
                String str = in.readLine();
                if(str.charAt(0) == '+') {
                    n++;
                } else if(str.charAt(0) == '-') {
                    n--;
                } else {
                    String[] s = str.split(":");
                    if(s.length != 1)
                        bytes += s[1].length() * n;
                }
            } catch (NullPointerException npe) { b = false; }
            //} catch (NoSuchElementException nsee) { b = false; }
            i++;
        }
        System.out.print(bytes);
    }
}