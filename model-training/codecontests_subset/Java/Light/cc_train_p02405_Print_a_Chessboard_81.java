import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int H = sc.nextInt(), W = sc.nextInt();
            if(H==0 && W==0) {
                break;
            }
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    System.out.printf((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0) ? "#" : ".");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
