import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        
        char[] input = in.nextLine().toCharArray();
        int[] cntArray = new int[10];
        for(int i = 0; i < N; i++) {
            cntArray[Character.getNumericValue(input[i])]++;
        }
        
        int count = Math.min(cntArray[8], N / 11);
        System.out.println(count);
    }
}