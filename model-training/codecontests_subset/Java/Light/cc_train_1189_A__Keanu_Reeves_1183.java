import java.util.Scanner;


public class kianu {


    private static boolean nice(char[] number) {
        int x = 0, y = 0;

        for (char c: number) {
            if (c == '0')
                x++;
            else
                y++;
        }

        return x != y;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String number = in.next();

        if (nice(number.toCharArray())) {
            System.out.println(1 + "\n" + number);
            System.exit(0);
        } else {
            System.out.println(2 + "\n" + number.charAt(0) + " " + number.substring(1));
            System.exit(0);
        }

    }


}
