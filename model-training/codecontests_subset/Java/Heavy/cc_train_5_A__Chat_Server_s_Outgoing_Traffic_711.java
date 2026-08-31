//package Codeforces;
import java.io.*;

/**
 * Created by Никита on 24.07.2016.
 */
public class Traffic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long a=0;
        String input = "";
        long traffic = 0;
        try {
            while (!(input = reader.readLine()).isEmpty()) {
                char i = input.charAt(0);
                if (i == '+') {
                    a++;
                    continue;
                }
                if (i == '-')
                    a--;
                else {
                    traffic = traffic + input.substring(input.indexOf(":") + 1).length() * a;
                }
            }
        }catch (NullPointerException e){}
        System.out.print(traffic);
    }
}
