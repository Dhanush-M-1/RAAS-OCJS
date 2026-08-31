import java.util.*;
import java.io.*;
public class A {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str=new StringTokenizer(k.readLine());
        
        int[]array = new int[5];
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(str.nextToken());
            total += array[i];
        }
        if (total % 5 == 0 && total != 0) {
            System.out.println(total / 5);
        }
        else {
            System.out.println(-1);
        }

    }

}
