import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int H = scanner.nextInt(), W = scanner.nextInt();
            if(H==0 && W==0) break;
            for (int j=0;j<H;j++) {
                for(int i=0;i<W;i++){
                    if(0==((i+j)%2)) System.out.print("#");
                    else System.out.print(".");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
