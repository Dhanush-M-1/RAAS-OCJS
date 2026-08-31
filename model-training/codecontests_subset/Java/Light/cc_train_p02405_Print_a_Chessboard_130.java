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

            for (int a=0; a<w; ++a) {
             for (int b=0; b<h; ++b) {
              System.out.print(((a+b)%2==1 ? "." : "#"));
              }
             System.out.println("");
             }
            System.out.println("");
            }
    sc.close();
    }
}

