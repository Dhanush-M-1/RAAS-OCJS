
import java.util.*;

public class SumaDeString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        String a = in.nextLine();
        ArrayList<Integer> ww = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != '.') {
                ww.add(i + 1);
            }
        }
        int c = 0;
        int j = c + 1;
        int u = j;
        int weed = 1;
        int x = 3;
        boolean d = false;
        String men = "no";
        while (c < (ww.size() - 3) && d == false && ww.size() > 3) {
            int A = ww.get(c);//2
            while (j < ww.size() - x && d == false) {
                int B = ww.get(j);//5
                int N = B - A;//3
                int aux = j;
                do {
                    d = false;
                    for (int i = aux; i < ww.size(); i++) {
                        if (B + N == ww.get(i)) {
                            weed++;
                            d = true;
                            B += N;
                            aux = i;
                            break;
                        }
                    }
                    if (weed == 4) {
                        men = "yes";
                        break;
                    }
                } while (d);
                j++;
                weed = 1;
            }
            u++;
            j = u;
            x++;
            c++;
        }
        System.out.println(men);
    }
}
