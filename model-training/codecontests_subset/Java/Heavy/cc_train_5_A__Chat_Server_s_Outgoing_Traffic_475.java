import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int activeUsers = 0;
        int traffic = 0;
        while(scanner.hasNextLine()){
            String user = scanner.nextLine();
            if (user.substring(0,1).equals("+")) {
                ++activeUsers;
            } else if (user.substring(0,1).equals("-")) {
                --activeUsers;
            } else {
                int position = user.indexOf(":");
                String message = user.substring(position + 1);
                traffic += message.length() * activeUsers;
            }
        }
        System.out.print(traffic);
    }
}
