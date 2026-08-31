import java.util.Scanner;

public class Apple {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int w = 0;
        int wa100 = 0, wa200 = 0;
        int wb100 = 0, wb200 = 0;

        for (int i = 1; i <= n; i++) {
            w = kb.nextInt();
            if (w == 100)
                wa100++;
            else
                wa200++;

        } 
        int tempA200 = wa200;
        int tempA100 = wa100;
        for (int i = 0; i <= tempA100; i++) {
            wb200 = 0;
            wa200 = tempA200;
            for (int j = 0; j <= tempA200; j++) {

                if ((100 * wa100 + 200 * wa200) == (100 * wb100 + 200 * wb200)) {
                    System.out.println("YES");
                    return;
                }

                wa200--;
                wb200++;
            }
            wa100--;
            wb100++;
        }
        System.out.print("NO");
    }
}