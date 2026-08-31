import java.util.*;
 
public class Practice {

    public static void main(String[] args) {
 
		Scanner scan = new Scanner(System.in);
        
		int t = scan.nextInt();

        while (t --> 0) {

            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a1 = new int[n];
            int[] a2 = new int[m];
            int[] a3 = new int[1];

            for (int i = 0; i < n; i++) a1[i] = scan.nextInt();

            for (int i = 0; i < m; i++) a2[i] = scan.nextInt();

            boolean flag = false;

            outerloop:
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {

                    if (a1[i] == a2[j]) {

                        a3[0] = a1[i];
                        flag = true;
                        break outerloop;
                    }
                }
            }

            if (flag) {

                System.out.println("YES" + "\n" + "1" + " " + a3[0]);
            } else System.out.println("NO");
        }

		scan.close();
	}
}