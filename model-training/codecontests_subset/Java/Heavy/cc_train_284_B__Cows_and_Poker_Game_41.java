//Created by Aminul on 10/9/2020.

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class G {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        int a = 0, f = 0, x = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'A') a++;
            else if (s[i] == 'F') f++;
            else x++;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'A' && x == 0) {
                cnt++;
            } else if (s[i] == 'I' && x == 1) {
                cnt++;
            }
        }

        pw.println(cnt);

        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
	 		  	     	    		 	