import java.util.Scanner;

public class Main {
    static void printBox(int H, int W) {
        char[] pat = {'#','.'};
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                System.out.print(pat[(i+j) % 2]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            int H = in.nextInt();
            int W = in.nextInt();
            if(H == 0) break;
            printBox(H, W);
        }
    }
}