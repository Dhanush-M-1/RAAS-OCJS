import java.util.*;

public final class ChatServersOutgoingTraffic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<String>();
        int c = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.charAt(0) == '+') set.add(line.substring(1));
            else if (line.charAt(0) == '-') set.remove(line.substring(1));
            else c+= line.substring(line.indexOf(':') + 1).length() * set.size();
        }
        System.out.println(c);
    }
}
