import java.io.*;
import java.util.*;

public class problemA {
    //    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = 1;
//        t = Integer.parseInt(in.readLine());
        t = in.nextInt();
        while (t != 0) {
            play();
            t--;
        }
    }

    public static void play() throws IOException {
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        if (n % 3 == 0 || n % 3 == 1) {
            System.out.println(n % 3 == 0 ? a : b);
            return;
        } else {
            System.out.println(a ^ b);
        }
    }
}


			  	  	 	  	 							 	 	  		