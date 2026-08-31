import java.io.IOException;
import java.util.Scanner;

/**
 * Created by peter.bykov on 13.05.2014.
 */
public class Archive5A  {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int countOfUsers = 0;
        int traffic = 0;
        String[] message;
        String input;
        do {
            input = s.nextLine();
            if(input.startsWith("+")) {
                ++countOfUsers;
            } else if(input.startsWith("-")) {
                --countOfUsers;
            } else {
                message = input.split(":");
                traffic += countOfUsers * (input.length() - (message[0].length() + 1));
            }
        } while (s.hasNextLine());
        System.out.println(traffic);
    }
}