import java.util.*;
import java.math.*;
import java.io.*;
public class LOL {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int people = 0;
        long ans = 0;
        while(in.hasNextLine()) {
            String line = in.nextLine();
            if (line.charAt(0) == '+')
                people++;
            else if (line.charAt(0) == '-')
                people--;
            else {
                String[] s = line.split(":");
                if (s.length > 1)
                    ans += (long)people*s[1].length();
            }
        }
        System.out.println(ans);
    }
}