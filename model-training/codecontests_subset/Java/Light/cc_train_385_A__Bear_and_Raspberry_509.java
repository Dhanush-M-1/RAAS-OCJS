import java.util.Scanner;

public class Problem01 {

    public static void main(String[] args) {

        Scanner z = new Scanner(System.in);
        String[] nc = z.nextLine().split(" ");
        String[] xi = z.nextLine().split(" ");
        int p = 0;
        for (int i = 0; i < Integer.parseInt(nc[0]) - 1; i++) {
            int benef = Integer.parseInt(xi[i]) - Integer.parseInt(xi[i + 1]) - Integer.parseInt(nc[1]);
            if (p == 0 && benef >= 0) {
                p = benef;
            } else if (benef > p) {
                p = benef;
            }
        }
        System.out.println(p);
    }

}
