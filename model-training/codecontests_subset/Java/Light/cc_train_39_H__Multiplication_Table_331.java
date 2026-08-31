import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        for (int i = 1; i < base; i++) {
            for (int j = 1; j < base; j++) {
                System.out.print(String.format("%s ", Integer.toString(i*j, base)));
            }
            System.out.println();
        }
    }
}