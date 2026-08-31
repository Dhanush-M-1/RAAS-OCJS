
import java.io.*;
import java.util.*;

public class CF {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        int[] tab = new int[n];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.nextInt();
        }
        int[] tab1 = new int[n];
        tab1[0] = tab[0] - 1;
        for (int i = 1; i < tab1.length; i++) {
            tab1[i] += tab1[i - 1] + tab[i] - tab[i - 1];
        }
        int[] tab2 = new int[n];
        tab2[n - 1] = 1000000 - tab[n - 1];
        for (int i = n - 2; i > -1; i--) {
            tab2[i] += tab2[i + 1] + tab[i + 1] - tab[i];
        }
        int s = tab1[n - 1];
        for (int i = 0; i < n - 1; i++) {
            s = Math.min(s, Math.max(tab1[i], tab2[i + 1]));
        }
        s = Math.min(s, tab2[0]);
        out.println(s);
        out.close();
    }

}
