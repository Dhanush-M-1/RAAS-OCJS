import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
public class C {

    static class Chip {
        Chip[] nbrs;
        int dir;
        public Chip(int d) {
            dir = d;
            nbrs = new Chip[4];
        }
    }

    int[] D;

    public C() throws Exception {
        D = new int[128];
        D['U'] = 0;
        D['R'] = 1;
        D['D'] = 2;
        D['L'] = 3;

        int n = in.nextInt();
        int m = in.nextInt();
        char[][] map = new char[n][];
        for (int i=0;i<n;i++) {
            map[i] = in.next().toCharArray();
        }
        
        Chip[][] chips = new Chip[n][m];
        for (int r=0;r<n;r++) {
            for (int c=0;c<m;c++) {
                if (map[r][c]=='.') continue;
                chips[r][c] = new Chip(D[map[r][c]]);
            }
        }

        int max = -1;
        int times = -1;

        for (int r=0;r<n;r++) {
            for (int c=0;c<m;c++) {
                if (map[r][c]=='.') continue;

                for (int c2=0;c2<m;c2++) { // U {{{ 
                    Chip pre = null;
                    for (int r2=0;r2<n;r2++) {
                        if (map[r2][c2]=='.') continue;
                        chips[r2][c2].nbrs[D['U']] = pre;
                        pre = chips[r2][c2];
                    }
                } // }}}

                for (int r2=0;r2<n;r2++) { // L {{{
                    Chip pre = null;
                    for (int c2=0;c2<m;c2++) {
                        if (map[r2][c2]=='.') continue;
                        chips[r2][c2].nbrs[D['L']] = pre;
                        pre = chips[r2][c2];
                    }
                } // }}}

                for (int c2=0;c2<m;c2++) { // D {{{
                    Chip pre = null;
                    for (int r2=n-1;r2>=0;r2--) {
                        if (map[r2][c2]=='.') continue;
                        chips[r2][c2].nbrs[D['D']] = pre;
                        pre = chips[r2][c2];
                    }
                } // }}}

                for (int r2=0;r2<n;r2++) { // R {{{
                    Chip pre = null;
                    for (int c2=m-1;c2>=0;c2--) {
                        if (map[r2][c2]=='.') continue;
                        chips[r2][c2].nbrs[D['R']] = pre;
                        pre = chips[r2][c2];
                    }
                } // }}}

                int count = 0;
                Chip chip = chips[r][c];
                while (chip!=null) {
                    count++;

                    for (int i=0;i<4;i++) {
                        if (chip.nbrs[i]==null) continue;
                        chip.nbrs[i].nbrs[i^2] = chip.nbrs[i^2];
                    }

                    chip = chip.nbrs[chip.dir];
                }

                if (max<=count) {
                    if (max<count) {
                        max = count;
                        times = 0;
                    }
                    times++;
                }


            }
        }



        buf.append(max).append(' ').append(times).append('\n');
        System.out.print(buf);
    }

    Scanner in = new Scanner(System.in);
    StringBuilder buf = new StringBuilder();
    public static void main(String[] args) throws Exception { // {{{
        new C();
    } // }}}
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
}
