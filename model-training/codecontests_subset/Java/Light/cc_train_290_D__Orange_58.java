import java.util.Scanner;

public class Orange {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String x = input.nextLine();
        int z = input.nextInt();

        x = x.toLowerCase();
        String s = "";

        for (int i = 0; i < x.length(); i++) {
            String a = "";
            if (x.charAt(i) < z + 97) {
                a += x.charAt(i) + "";
                a = a.toUpperCase();
            } else {
                a += x.charAt(i) + "";
            }
            s += a;
        }
        System.out.println(s);

    }

}
