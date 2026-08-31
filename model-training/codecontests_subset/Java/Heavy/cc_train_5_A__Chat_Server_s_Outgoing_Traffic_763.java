import java.io.*;
import java.util.*;

public class ChatServersOutgoingTraffic {
    BufferedReader reader;

    private void solve() throws IOException {
        String line = "";
        Set<String> friends = new HashSet<String>();
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            if (line.charAt(0) == '+')
                friends.add(line.substring(1));
            else if (line.charAt(0) == '-')
                friends.remove(line.substring(1));
            else {
                line = line.substring(line.indexOf(':') + 1);
                counter += friends.size() * line.length();
            }
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new ChatServersOutgoingTraffic().run();
    }

    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
