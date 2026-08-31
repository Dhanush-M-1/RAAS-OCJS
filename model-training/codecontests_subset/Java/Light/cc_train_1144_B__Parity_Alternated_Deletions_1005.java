import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner (in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        
        int n = sc.nextInt();
        int[] odd = new int[n];
        int[] even = new int[n];
        int oddIndex = 0, evenIndex = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input % 2 == 0) {
                even[evenIndex++] = input;
            } else {
                odd[oddIndex++] = input;
            }
        }
        
        Arrays.sort(odd, 0, oddIndex);
        Arrays.sort(even, 0, evenIndex);
        long sum = 0;
        if (oddIndex - 1> evenIndex) {
            int index = 0;
            while (oddIndex - 1 - index> evenIndex) sum += odd[index++];
        } else if (evenIndex - 1> oddIndex) {
            int index = 0;
            while (evenIndex - 1 - index> oddIndex) sum += even[index++];
        }
        
        writer.write(String.valueOf(sum));
        writer.write(lineSeparator());
        writer.flush();
    }
}