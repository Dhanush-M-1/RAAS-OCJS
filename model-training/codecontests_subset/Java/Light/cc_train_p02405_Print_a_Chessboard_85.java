import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        char[] c = {'#', '.'};

        Scanner sc = new Scanner(System.in);
        while (true) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            if (h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(c[(i + j) & 1]);
                }
                System.out.println("");
            }
            System.out.println("");
        }

    }

}
