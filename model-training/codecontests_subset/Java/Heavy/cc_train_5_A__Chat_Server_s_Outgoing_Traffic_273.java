import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://codeforces.com/problemset/problem/5/A
public class Solve5A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> users = new HashSet<>();
        int bytes = 0;
        while (true) {
            String chat = br.readLine();
            if (chat == null) {
                break;
            }
            if (chat.contains(":")) {
                String[] token = chat.split(":");
                int msgCnt = token.length >= 2 ? token[1].length() : 0;
                bytes += (msgCnt * users.size());
            } else {
                if (chat.startsWith("+") || chat.startsWith("-")) {
                    char oper = chat.charAt(0);
                    String user = chat.substring(1);
                    if (oper == '+') {
                        users.add(user);
                    } else {
                        users.remove(user);
                    }
                }
            }
        }

        System.out.println(bytes);
    }
}