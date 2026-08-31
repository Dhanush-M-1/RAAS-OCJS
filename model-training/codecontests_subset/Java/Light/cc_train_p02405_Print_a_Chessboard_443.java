import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            if(a == 0 && b == 0) break;

            for(int i = 0; i < a; i++){
                for(int j = 0; j < b; j++){
                    if((i + j) % 2 == 0) System.out.printf("#");
                    else System.out.printf(".");
                }
                System.out.printf("\n");
            }
            System.out.printf("\n");
        }
    }
}
