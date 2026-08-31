/**
 * Created by scott on 3/25/2015.
 */

import java.util.*;

public class Chat {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args){
        int total = 0;
        int users = 0;

        while(console.hasNextLine()) {
            String input = console.nextLine();
            int bytes;
            if (input.charAt(0) == '+')
                users = users + 1;
            else if (input.charAt(0) == '-')
                users = users - 1;
            else {
                bytes = (input.length() - input.indexOf(":") - 1) * users;
                total = total + bytes;
            }
        }

        System.out.println(total);
    }
}
