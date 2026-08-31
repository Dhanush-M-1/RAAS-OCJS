import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Solution {


    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sumTraffic = 0;
        Vector<String> users = new Vector<String>(100);
        String str;
        while ((str = br.readLine()) != null) {
            if (str.isEmpty()) {
                continue;
            }
            if (str.charAt(0) == '+') {
                users.add(str.substring(1).trim());
                continue;
            }
            if (str.charAt(0) == '-') {
                users.remove(str.substring(1).trim());
                continue;
            }
            String s = str.substring(str.indexOf(":") + 1);
            sumTraffic += s.length() * users.size();

        }

        System.out.println(sumTraffic);

    }
}