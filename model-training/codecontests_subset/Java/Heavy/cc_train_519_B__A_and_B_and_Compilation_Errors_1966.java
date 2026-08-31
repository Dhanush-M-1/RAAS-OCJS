import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ABCompilationError519B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        String[] initialLine = br.readLine().split(" ");
        String[] cor1Line = br.readLine().split(" ");
        String[] cor2Line = br.readLine().split(" ");
        
        int[] initial = new int[n];
        int[] cor1 = new int[n - 1];
        int[] cor2 = new int[n - 2];

        for (int i = 0; i < n - 2; i++) {
            initial[i] = Integer.parseInt(initialLine[i]);
            cor1[i] = Integer.parseInt(cor1Line[i]);
            cor2[i] = Integer.parseInt(cor2Line[i]);
        }

        cor1[n - 2] = Integer.parseInt(cor1Line[n - 2]);
        initial[n - 2] = Integer.parseInt(initialLine[n - 2]);
        initial[n - 1] = Integer.parseInt(initialLine[n - 1]);

        int correction1;
        int correction2;

        correction1 = missing(initial, cor1);
        correction2 = missing(cor1, cor2);

        System.out.println(correction1);
        System.out.println(correction2);
        
    }
    
    private static int missing(int[] initial, int[] array) {
        Arrays.sort(initial);
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (initial[i] != array[i]) return initial[i];
        } return initial[initial.length - 1];
    }
}
