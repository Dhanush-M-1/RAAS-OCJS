import java.util.Scanner;

public class HelpfulMath {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] map = new int[3];

        String command = in.nextLine();
        StringBuilder newCommand = new StringBuilder();
        for (char c: command.toCharArray()) {
            if (c == '1') {
                map[0] +=1;
            }
            else if (c == '2') {
                map[1] +=1;
            }
            else if (c == '3') {
                map[2] +=1;
            }
        }
        for (int i = 0; i < map.length; i ++) {
            int curr = map[i];
            while(curr > 0) {
                newCommand.append((i + 1) + "+");
                curr--;
            }
        }
        if (newCommand.length() > 0) {
            newCommand.setLength(newCommand.length() - 1);
        }
        System.out.println(newCommand.toString());
    }
}
