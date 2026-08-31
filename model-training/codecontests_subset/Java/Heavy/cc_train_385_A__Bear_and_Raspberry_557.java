import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        new Main();
    }
    StreamTokenizer in = new StreamTokenizer(System.in);
    int ni() throws Exception {
        in.nextToken();
        return (int)in.nval;
    }
    Main() throws Exception {
        int n1 = ni();
        int c1= ni();
        int[] l1 = new int[n1];
        for (int i =0; i < n1; i++){
            l1[i] = ni();
        }
        int max = 0;
        for (int i =0 ; i < l1.length - 1; i++){
            int diff = l1[i] - l1[i + 1];
            if (diff < 0) continue;
            diff -= c1;
            if (diff >= 0){
                max = Math.max(diff, max);
            }
        }
        System.out.println(max);
    }
}
