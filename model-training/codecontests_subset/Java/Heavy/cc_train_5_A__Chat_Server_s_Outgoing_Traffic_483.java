import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.*;

/**
 * @author Alexander Kuznetsov
 */
public class Solution {
    public void solve() throws IOException{
        //Scanner in = new Scanner(new File("input.txt"));
        Scanner in = new Scanner(System.in);
        
        int otv = 0;
        Set<String> users = new HashSet<String>();
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.startsWith("+")) {
                users.add(s.substring(1));
            } else if (s.startsWith("-")){
                users.remove(s.substring(1));
            } else {

                String[] m = s.split(":");
                if (m.length > 1) {
                    otv += m[1].length() * users.size();
                }

            }
        }

        System.out.println(otv);
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}
