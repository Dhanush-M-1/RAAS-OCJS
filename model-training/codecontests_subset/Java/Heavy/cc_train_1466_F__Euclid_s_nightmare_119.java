

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Coding {

    private static BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static long MOD = (long)(1e9+7);
    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean union(int a, int b, int[] par, int[] rank) {
        int aPar = findPar(a, par);
        int bPar = findPar(b, par);
        if (aPar == bPar) return false;
        if (rank[aPar]<rank[bPar]) {
            par[aPar] = bPar;
        } else if (rank[aPar]>rank[bPar]) {
            par[bPar] = aPar;
        } else {
            par[aPar] = bPar;
            rank[bPar]++;
        }
        return true;
    }

    public static void initialize(int[] par, int[] rank, int n) {
        for(int i=0;i<=n;++i) {
            par[i] = i;
            rank[i] = 1;
        }
    }

    private static int findPar(int cur, int[] par) {
        while (par[cur]!=cur) cur = par[cur];
        return cur;
    }

    public static void run() throws Exception {
        InputModule inp = new InputModule();
        OutputModule out = new OutputModule();
        int t = 1;
        while (t > 0) {
            int[] ints = inp.cinIntArray(2);
            int n = ints[0];
            int m = ints[1];
            int[] par = new int[m+1];
            int[] rank = new int[m+1];
            initialize(par, rank, m);
            List<Integer> ans = new ArrayList<>();
            long total = 1;
            for(int i=1;i<=n;++i) {
                String[] iStr = inp.cinString().split(" ");
                int k = Integer.parseInt(iStr[0].trim());
                if (k==1) {
                    boolean poss = union(0, Integer.parseInt(iStr[1].trim()), par, rank);
                    if (poss) {
                        total = (total*2)%MOD;
                        ans.add(i);
                    }
                } else {
                    boolean poss = union(Integer.parseInt(iStr[1].trim()), Integer.parseInt(iStr[2].trim()), par, rank);
                    if (poss) {
                        total = (total*2)%MOD;
                        ans.add(i);
                    }
                }
            }
            writer.append(total + " " + ans.size() + "\n");
            writer.flush();
            out.printIntList(ans);
            t--;
        }
    }


    private static class InputModule {
        private int cinInt() throws Exception {
            return Integer.parseInt(bi.readLine().split(" ")[0].trim());
        }

        private long cinLong() throws Exception {
            return Long.parseLong(bi.readLine().split(" ")[0].trim());
        }

        private Double cinDouble() throws Exception {
            return Double.parseDouble(bi.readLine().split(" ")[0].trim());
        }

        private String cinString() throws Exception {
            return bi.readLine();
        }

        private int[] cinIntArray(int n) throws Exception {
            String input = bi.readLine();
            String[] values = input.split(" ");
            int[] ar = new int[n];
            for (int i = 0; i < n; ++i) {
                ar[i] = Integer.parseInt(values[i]);
            }
            return ar;
        }

        private int[] cinIntArray() throws Exception {
            String input = bi.readLine();
            String[] values = input.split(" ");
            int[] ar = new int[values.length];
            for (int i = 0; i < values.length; ++i) {
                ar[i] = Integer.parseInt(values[i]);
            }
            return ar;
        }

        private long[] cinLongArray(int n) throws Exception {
            String input = bi.readLine();
            String[] values = input.split(" ");
            long[] ar = new long[n];
            for (int i = 0; i < n; ++i) {
                ar[i] = Long.parseLong(values[i]);
            }
            return ar;
        }

        private String[] cinStringArray(int n) throws Exception {
            return bi.readLine().split(" ");
        }
    }

    private static class OutputModule {
        private void printInt(int ans) throws Exception {
            writer.append(ans + "\n");
            writer.flush();
        }

        private void printLong(long ans) throws Exception {
            writer.append(ans + "\n");
            writer.flush();
        }

        private void printDouble(Double ans) throws Exception {
            writer.append(String.format("%.10f", ans));
            writer.append("\n");
            writer.flush();
        }

        private void printString(String ans) throws Exception {
            writer.append(ans + "\n");
            writer.flush();
        }

        private void printIntArray(int[] ans) throws Exception {
            for (int i = 0; i < ans.length; ++i) {
                writer.append(ans[i] + " ");
            }
            writer.append("\n");
            writer.flush();
        }

        private void printLongArray(long[] ans) throws Exception {
            for (int i = 0; i < ans.length; ++i) {
                writer.append(ans[i] + " ");
            }
            writer.append("\n");
            writer.flush();
        }

        private void printIntList(List<Integer> list) throws Exception {
            for (int i = 0; i < list.size(); ++i) {
                writer.append(list.get(i) + " ");
            }
            writer.append("\n");
            writer.flush();
        }

        private void printLongList(List<Long> list) throws Exception {
            for (int i = 0; i < list.size(); ++i) {
                writer.append(list.get(i) + " ");
            }
            writer.append("\n");
            writer.flush();
        }

        private void printIntMatrix(int[][] mat, int n, int m) throws Exception {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    writer.append(mat[i][j] + " ");
                }
                writer.append("\n");
            }
            writer.flush();
        }

        private void printLongMatrix(long[][] mat, int n, int m) throws Exception {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    writer.append(mat[i][j] + " ");
                }
                writer.append("\n");
            }
            writer.flush();
        }

        private void printPoint(Point p) throws Exception {
            writer.append(p.x + " " + p.y + "\n");
            writer.flush();
        }

        private void printPoints(List<Point> p) throws Exception {
            for (Point pp : p) {
                writer.append(pp.x + " " + pp.y + "\n");
            }
            writer.flush();
        }
    }
}