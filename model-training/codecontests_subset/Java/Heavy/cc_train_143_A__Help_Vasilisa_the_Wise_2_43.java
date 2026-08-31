
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Labing Dell
 */
public class E {
    static int n1 = 0;
    static int n2 = 0;
    static int n3 = 0;
    static int n4 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int mat[][] = new int[3][2];
        String l[] = {};
        for (int i = 0; i < 3; i++) {
            l = in.readLine().split(" ");
            mat[i][0] = Integer.parseInt(l[0]);
            mat[i][1] = Integer.parseInt(l[1]);
        }
        boolean bol = false;
        for (int i = 1; i <= 9; i++) {
            n1 = i;
            bol = comp1(1, mat);
            if (bol) {
                break;
            }
        }
        HashSet<Integer> pru=new HashSet<>();
        pru.add(n1);
        pru.add(n2);
        pru.add(n3);
        pru.add(n4);
        if (bol && pru.size()==4 ) {
            System.out.println(n1 + " " + n2);
            System.out.println(n3 + " " + n4);
        } else {
            System.out.println("-1"); 
        }
    }

    public static boolean comp1(int caso, int mat[][]) {
        int val = 0;
        switch (caso) {
            case 1:
                val = mat[0][0] - n1;
                if (val > 0 && val<10) {
                    n2 = val;
                    return comp1(2, mat);
                }
                break;
            case 2:
                val = mat[2][1] - n2;
                if (val > 0 && val<10) {
                    n3 = val;
                    if ((n1 + n3) == mat[1][0]) {
                        return comp1(3, mat);
                    }
                }
                break;
            case 3:
                val = mat[0][1] - n3;
                if (val > 0 && val<10) {
                    n4 = val;
                    if ((n1 + n4) == mat[2][0] && (n2 + n4) == mat[1][1]) {
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
            default:
                break;
        }

        return false;
    }
}