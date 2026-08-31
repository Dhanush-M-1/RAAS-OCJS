import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//try {
            //PrintWriter pw = new PrintWriter("test.txt");
            int n = scan.nextInt();scan.nextLine();
            String[] F = new String[n];
            Arrays.fill(F, "");
            int[] f = new int[n];
            int[][] p = new int[n][11];

            for (int i = 0; i < n; i++) {
            	F[i] = F[i]+scan.nextLine();
            	F[i] = F[i].replaceAll(" ", "");
            	f[i] = Integer.parseInt(F[i], 2);
            }

            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < 11; j++) {
            		p[i][j] = scan.nextInt();
            	}
            }

            int ans = Integer.MIN_VALUE;

            for (int bit = 0; bit < (1 << 10); bit++) {
            	if (Integer.bitCount(bit) == 0) continue;
            	int pro = 0;
            	for (int i = 0; i < n; i++) {
            		int cnt = 0;
            		//pw.println("bit : "+Integer.toBinaryString(bit));
            		//pw.println("f["+i+"] : "+Integer.toBinaryString(f[i]));
            		cnt = Integer.bitCount(bit&f[i]);
            		//pw.println("cnt : " + cnt);
            		pro += p[i][cnt];
            	}
            	//pw.println("pro : "+pro);
            	ans = Math.max(ans, pro);
            }

            //pw.println(ans);
            System.out.println(ans);
            /*pw.close();
		*} catch (IOException ex) {
			*ex.printStackTrace();
		}
		*/
	}
}
