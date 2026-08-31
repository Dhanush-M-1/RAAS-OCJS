import java.util.Scanner;

public class P005A {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        int bytes = 0;
        int people = 0;
        while (inScanner.hasNext()) {
            String command = inScanner.nextLine();
            if (command.charAt(0) == '+')
                people++;
            else if (command.charAt(0) == '-')
                people--;
            else
                bytes += people * command.split(":", -1)[1].length();
        }
        System.out.println(bytes);
    }
}
