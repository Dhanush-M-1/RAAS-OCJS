import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader obj = new BufferedReader(new FileReader("/Users/Testdrive/Desktop/uva.txt"));
        PrintWriter prin = new PrintWriter(System.out);

        int compile_error = Integer.parseInt(obj.readLine());

        StringTokenizer tty = new StringTokenizer(obj.readLine());

        int[] array_num = new int[compile_error];

        for (int i = 0; i < array_num.length; i++) {
            array_num[i] = Integer.parseInt(tty.nextToken());
        }

        Arrays.sort(array_num);
        compile_error--;

        String line;
        while ((line = obj.readLine()) != null) {
            tty = new StringTokenizer(line);
            int[] sub = new int[compile_error];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = Integer.parseInt(tty.nextToken());
            }
            Arrays.sort(sub);
            int counter = 0;

            boolean found = false;

            for (int i = 0; i < sub.length; i++) {
                if (sub[i] != array_num[i]) {
                    counter = i;
                    found = true;
                    break;
                } else {
                    counter = i;
                }
            }

            if (found) {
                prin.println(array_num[counter]);
            } else {
                counter++;
                prin.println(array_num[counter]);
            }

            array_num = sub;
            compile_error--;
            int b = 3;
        }
        prin.flush();
    }

}
