import java.util.Scanner;

/**
 * Created by alok.mahajan on 04/03/2018.
 */
public class p1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();
        int c;
        if (a > b) {
            c = a - b;
        }
        else {
            c = b - a;
        }

        if (c==1){
            System.out.println(c);;
        }
        else {
            int C = (c/2) + 1;
            double temp;
            int ans = 0;
            int ans1 = 0;

            if (c % 2 == 0) {
                for (int i = 0; i < C; i++) {
                    ans = ans + i;
                    //System.out.println(ans);
                }
                System.out.println(ans * 2);
            }
            else {
                //temp = (ans * 2) * 1.5;
                for (int i = 0; i <= C; i++) {
                    ans1 = ans;
                    ans = ans + i;

                    //System.out.println("Calc ans:"+ans+"  And Ans1:"+ans1);
                }
                temp = ans+ ans1;
                //System.out.println("Second Loop"+(int)temp);
                System.out.println((int)temp);
            }

        }
    }
}