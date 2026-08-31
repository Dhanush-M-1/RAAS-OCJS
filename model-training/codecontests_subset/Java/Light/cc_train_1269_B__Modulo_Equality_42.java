

import java.io.*;
import java.util.Arrays;

public class Sorting {
    public static void main(String args[]) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String items[] = br.readLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int m = Integer.parseInt(items[1]);

        int a[] = new int[n];
        int b[] = new int[n];
        items = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(items[i]);
        }
        items = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(items[i]);
        }
        // Arrays.sort(a);
        Arrays.sort(b);
        long max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long x = (b[0]-a[i]+m) % m;

            int crr[] = new int[n];
            for (int j = 0; j < n; j++) {
                crr[j] = (int) (a[j] + x) % m;
            }
            Arrays.sort(crr);
            if (same(b, crr))
                max = Math.min(max, x);

    }
            out.write(max+"\n");
        out.flush();

    }

    private static boolean same(int[] b, int[] crr) {
        for(int i=0;i<b.length;i++){
            if(b[i]!=crr[i]){
                return false;
            }
        }
        return true;
    }


}
