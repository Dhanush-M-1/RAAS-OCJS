import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine();
            int strLength = str.length();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'S') {
                    count++;
                } else {
                    if (count > 0) {
                        count--;
                        strLength -= 2;
                    }
                }
            }
            System.out.println(strLength);
        } catch (IOException e) {
            e.printStackTrace();
           }
    }
}
