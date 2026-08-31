import java.io.*;
import java.util.*;

public class codeforce_438A {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> first = new HashSet<>();
        Set<Character> last = new HashSet<>();
        String target = stdin.readLine();
        int n = Integer.parseInt(stdin.readLine());
        for(int i = 0; i < n; i++) {
            String next = stdin.readLine();
            if(next.equals(target)) {
                System.out.println("YES");
                stdin.close();
                System.exit(0);
                return;
            }
            first.add(next.charAt(0));
            last.add(next.charAt(1));
        }
        if(last.contains(target.charAt(0)) && first.contains(target.charAt(1))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        stdin.close();
        System.exit(0);
    }
}


