import java.util.Scanner;

public class A5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long totalUsers = 0;
        long sended = 0;
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.startsWith("+")) ++totalUsers;
            else if (s.startsWith("-")) --totalUsers;
            else sended += (s.substring(s.indexOf(':')+1).length() * (totalUsers));
        }
        System.out.println(sended);
    }
}
