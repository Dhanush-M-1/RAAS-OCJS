import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w + h == 0) {
                break;
            }
            for (int i=0; i<w; ++i) {
                for (int j=0; j<h; ++j) {
                    System.out.print(((i+j)%2==1 ? "." : "#"));
                }
                System.out.println("");
            }
            System.out.println("");
        }
        sc.close();
    }
}
