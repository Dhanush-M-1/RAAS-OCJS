import java.util.*;
import java.io.*;

public class Main {
    public static void wall(String[][] arr, int n) {
        // for(int i = 0; i < arr.length; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        String x = arr[0][1];
        String y = arr[1][0]; 
        String w = arr[n-1][n-2];
        String z = arr[n - 2][n - 1];

        int xx = 1, xy = 2;
        int yx = 2, yy = 1;
        int wx = n, wy = n-1;
        int zx = n-1, zy = n;

        int count = 0;
        List<Integer> list = new ArrayList<>();
        
        if(x.equals(y)) {
            if(x.equals("0")) {
                if(w.equals("0") && z.equals("0")) {
                    list.addAll(Arrays.asList(wx, wy, zx, zy));
                    count = 2;
                } else if(w.equals("0") && z.equals("1")) {
                    list.addAll(Arrays.asList(wx, wy));
                    count++;
                } else if(w.equals("1") && z.equals("0")) {
                    list.addAll(Arrays.asList(n-1, n));
                    count++;
                }
            } else {
                if(w.equals("0") && z.equals("1")) {
                    list.addAll(Arrays.asList(zx, zy));
                    count++;
                } else if(w.equals("1") && z.equals("0")) {
                    list.addAll(Arrays.asList(wx, wy));
                    count++;
                } else if(w.equals("1") && z.equals("1")) {
                    list.addAll(Arrays.asList(wx, wy, zx, zy));
                    count = 2;
                }
            }
        } else {
            if(x.equals("0")) {
                if(w.equals("0") && z.equals("0")) {
                    list.addAll(Arrays.asList(xx, xy));
                    count++;
                 } else if(w.equals("0") && z.equals("1")) {
                    list.addAll(Arrays.asList(xx, xy, zx, zy));
                    count = 2;
                 } else if(w.equals("1") && z.equals("0")) {
                    list.addAll(Arrays.asList(xx, xy, wx, wy));
                    count = 2;
                 } else if(w.equals("1") && z.equals("1")) {
                    list.addAll(Arrays.asList(yx, yy));
                     count++;
                 }
            } else {
                if(w.equals("0") && z.equals("0")) {
                    list.addAll(Arrays.asList(yx, yy));
                    count++;
                 } else if(w.equals("0") && z.equals("1")) {
                    list.addAll(Arrays.asList(yx, yy, zx, zy));
                    count = 2;
                 } else if(w.equals("1") && z.equals("0")) {
                    list.addAll(Arrays.asList(yx, yy, wx, wy));
                    count = 2;
                 } else if(w.equals("1") && z.equals("1")) {
                    list.addAll(Arrays.asList(xx, xy));
                    count++;
                 }
            }

        }
        System.out.println(count);
        int j = 1;
        for(int i = 0; i < list.size(); i++) {
            if(j%2==0) System.out.println(list.get(i) +" ");
            else System.out.print(list.get(i) + " ");
            j++;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String file = "./input.txt";
        //BufferedReader br = new BufferedReader(new FileReader(file));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            String[][] arr = new String[n][n];
            for(int i = 0; i < n; i++) {
                String[] row = br.readLine().split("");
                for(int j = 0; j < row.length; j++) {
                    arr[i][j] = row[j];
                }
            }
            wall(arr, n);
        }
    }
}