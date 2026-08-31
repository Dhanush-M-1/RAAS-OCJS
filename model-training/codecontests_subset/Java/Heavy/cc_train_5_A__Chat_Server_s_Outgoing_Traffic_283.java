import java.util.Scanner;

public class A5OutputChatTraffic {
    public static void main(String[] args) {
        System.out.println(trafficAmount());
    }

    private static int trafficAmount () {
        Scanner scanner = new Scanner(System.in);
        int chatMembers = 0;
        int informationSize = 0;
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equals("")) {
                break;
            }
            if (command.charAt(0) == '+') {
                chatMembers++;
                continue;
            }
            if (command.charAt(0) == '-') {
                chatMembers--;
                continue;
            }
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == ':') {
                    int messageLength = command.length() - i - 1;
                    informationSize += chatMembers * messageLength;
                    break;
                }
            }
        }
        return informationSize;
    }
}