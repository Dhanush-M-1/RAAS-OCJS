import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] argh) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
//        BufferedReader pr = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
//        String st = pr.readLine();
        int count = 0;

        for (int i = 1; i <= a; i++) {
            if(i%b == 0)
                a ++;
        }
        System.out.println(a);

    }

}
