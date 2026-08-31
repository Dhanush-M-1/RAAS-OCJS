import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int r = 0;
            int n = s.nextInt(), a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
            for(int i=0;i<=a;i+=2)
                for(int j=0;j<=c;j++){
                    int rem = n - (int) (0.5 * i) - 2 * j;
                    if (rem <= b && rem >= 0) {
                        r++;
                    }
                }
            System.out.println(r);
        }
    }
    
    void p(Object... g){
        System.out.println(deepToString(g));
    }
}