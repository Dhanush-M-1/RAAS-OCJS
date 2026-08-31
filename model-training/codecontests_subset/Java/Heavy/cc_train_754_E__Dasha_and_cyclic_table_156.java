import java.io.*;
import java.util.*;

public class E {

    static int[] newBitSet(int n) {
        return new int[(n + 31) / 32];
    }

    static void setBit(int[] a, int pos) {
        a[pos >>> 5] |= (1 << (pos & 31));
    }

    static boolean getBit(int[] a, int pos) {
        return ((a[pos >>> 5]) & (1 << (pos & 31))) != 0;
    }

    static void setAll(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = ~0;
        }
    }

    static void resetAll(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
    }

    static void andXYtoX(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            x[i] &= y[i];
        }
    }

    static void leftShiftAndOr(int ch, int shift, int x, int[][][][] shl, int[] to, int diff) {
        int[] z = shl[ch][shift & 31][x];
        int delta = (shift >>> 5);
				int ld = ((shift & 31) + diff) % 32;
				int hd = ((shift & 31) + diff) / 32;

        for (int i = 0; i < to.length; i++) {
            if (delta != 0) {
							if (i + delta < to.length) {
                to[i] = shl[ch][shift & 31][x][(i + delta)];
							} else {
								to[i] = shl[ch][ld][x][(hd + i + delta) % to.length];
							}
            } else {
                to[i] = shl[ch][shift & 31][x][i];
            }
        }	
    }

    static void rightShiftAndOr(int ch, int shift, int x, int[][][][] shr, int[] to) {
        int[] z = shr[ch][shift & 31][x];
        int delta = (shift >>> 5);
        for (int i = 0; i + delta < to.length; i++) {
            to[i + delta] |= z[i];
        }
    }

    static final int ALPHA = 26;

    public static void main(String[] args) throws Exception {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

				String[] L = br.readLine().split(" ");
				int n = Integer.parseInt(L[0]);
				int m = Integer.parseInt(L[1]);

        int[][][][] shl = new int[ALPHA][32][n][];
        int[][][][] shr = new int[ALPHA][32][n][];

        for (int c = 0; c < ALPHA; c++) {
            for (int sh = 0; sh < 32; sh++) {
                for (int i = 0; i < n; i++) {
                    shl[c][sh][i] = newBitSet(m);
                    shr[c][sh][i] = newBitSet(m);
                }
            }
        }

        String[] s = new String[n];

				int MC = ((m + 31) / 32) * 32;
				int diff = MC - m;

        for (int i = 0; i < n; i++) {
						s[i] = br.readLine();
            for (int j = 0; j < m; j++) {
                int c = s[i].charAt(j) - 'a';
                for (int sh = 0; sh < 32; sh++) {
										int wt = (m + (j - sh) % m) % m;
                    setBit(shl[c][sh][i], wt);
										if (wt < 32 && wt + m < MC) {
											setBit(shl[c][sh][i], wt + m);
										}

                    if (j + sh < m) {
                        setBit(shr[c][sh][i], j + sh);
                    }
                }
            }
        }

				L = br.readLine().split(" ");


				int r = Integer.parseInt(L[0]);
				int c = Integer.parseInt(L[1]);

        String[] patt = new String[r];

        int[][] res = new int[n][];

        for (int i = 0; i < n; i++) {
            res[i] = newBitSet(m);
            setAll(res[i]);
        }

        int[] tmp = newBitSet(m);

        for (int i = 0; i < r; i++) {
            patt[i] = br.readLine();
            for (int j = 0; j < c; j++) {
                if (patt[i].charAt(j) == '?') continue;
                int cur = patt[i].charAt(j) - 'a';
                int shiftByX = (((-i) % n) + n) % n;
                int shiftByY = (((j) % m) + m) % m;

                for (int x = 0; x < n; x++) {
                    int nx = x + shiftByX;
                    if (nx >= n) nx -= n;
                    resetAll(tmp);
                    leftShiftAndOr(cur, shiftByY, x, shl, tmp, diff);
//                    rightShiftAndOr(cur, m - shiftByY, x, shr, tmp);
                    andXYtoX(res[nx], tmp);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(getBit(res[i], j) ? '1' : '0');
            }
            out.println();
        }

        out.close();
    }
}
