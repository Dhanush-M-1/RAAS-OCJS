import java.io.File;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (; t > 0; t--) {
            int n = s.nextInt();
            int[] pair = new int[2];
            boolean type = true; // true - point, false - line
            pair[0] = s.nextInt();
            pair[1] = s.nextInt();
            for (int a = 1; a < n; a++) {
                int l = s.nextInt(), r = s.nextInt();
                if (l < pair[0] & r < pair[0]) {
                    if (type) {
                        type = false;
                        pair[1] = pair[0];
                    }
                    pair[0] = r;
                } else if (l > pair[1] & r > pair[1]) {
                    if (type) {
                        type = false;
                        pair[0] = pair[1];
                    }
                    pair[1] = l;
                } else {
                    if (l >= pair[0] & l <= pair[1])
                        if (type)
                            pair[0] = l;
                    if (r >= pair[0] & r <= pair[1])
                        if (type)
                            pair[1] = r;
                }
            }

            if(type){
                System.out.println(0);
            }
            else{
                System.out.println(pair[1] - pair[0]);
            }
        }
    }
}
