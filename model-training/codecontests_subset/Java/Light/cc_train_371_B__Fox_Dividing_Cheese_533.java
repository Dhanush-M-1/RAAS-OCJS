import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class Main {
    static BufferedReader read;
    static PrintWriter prnt;
    static StringTokenizer st;

    static int getMinimumOperation(int a, int b) {
        if (a == b) return 0;
        int[] arr = {2, 3, 5};
        int[] count = new int[3];

        int needOp = 0;
        for (int i = 0; i < 3; i++) {
            while (a % arr[i] == 0) {
                a = a / arr[i];
                count[i]++;
            }
            while (b % arr[i] == 0) {
                b = b / arr[i];
                count[i]--;
            }
            needOp += abs(count[i]);
        }
        if (a == b) return needOp;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        read = new BufferedReader(new InputStreamReader(System.in));
        prnt = new PrintWriter(System.out);
        st = new StringTokenizer(read.readLine());
        prnt.println(getMinimumOperation(parseInt(st.nextToken()), parseInt(st.nextToken())));
        prnt.close();
    }
}
				   	 			  	 		   	 	  		