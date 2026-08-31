import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task5A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Set<String> names = new HashSet<>();
        int x=0;
        while (scn.hasNextLine()) {
            String s = scn.nextLine();
            if (s.charAt(0) == '+') {
                names.add(s.substring(1));
            } else {
                if (s.charAt(0) == '-') {
                    names.remove(s.substring(1));
                } else {
                    String message = s.substring(s.indexOf(":")+1);
                    x=x+(message.length()*names.size());
                }
            }
        }
        System.out.println(x);
    }
}
