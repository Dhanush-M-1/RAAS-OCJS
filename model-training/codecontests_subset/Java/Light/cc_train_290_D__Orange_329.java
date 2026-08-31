import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P290D_Orange {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine().toLowerCase();
        int k = Integer.parseInt(in.readLine());
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) < 'a'+k) {
                System.out.print((char)(s.charAt(i)+'A'-'a'));
            } else {
                System.out.print(s.charAt(i));
            }
        }
    }
    
}