import java.util.Scanner;

public class Jumo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        int j = s.nextInt();
        String n = s.next();

        int max = 0;
        int tmp = 0;


       for (int l = 0; l <= j-5; l++){
        for (int m = 0; m <= j/4 + j%4; m++) {
           max = m;
            for (int i = l; i < j - max - 1; i++) {
                if (n.charAt(i) == '*' && n.charAt(i + max + 1) == '*') {
                    i = i + max;
                    tmp++;
                    if (tmp == 4) {
                        System.out.println("yes");
                        System.exit(0);
                    }
                } else
                    tmp = 0;
            }
            tmp = 0;
        }
           tmp = 0;
        }
            System.out.println("no");
    }
}
