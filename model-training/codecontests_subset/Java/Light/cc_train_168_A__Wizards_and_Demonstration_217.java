import java.io.PrintWriter;
import java.util.Scanner;

public class WizardsDemonstration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(), x = in.nextInt(), y = in.nextInt();
        int result = Math.max(0,  (int)Math.ceil((n*y*1.0d)/100 - x));

        out.println(result);
        out.close();
    }
}
