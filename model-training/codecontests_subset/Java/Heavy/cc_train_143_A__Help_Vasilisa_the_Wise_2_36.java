import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R102A {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] sums = readInts();
        int i,j = 0,k = 0,l = 0;
        boolean hasSol = false;
        for(i = 1; i <= 9; i++) {
            j = sums[0] - i;
            if(j == i || j < 0 || j > 9) continue;
            for(k = 1; k <= 9; k++) {
                if(k == i || k == j) continue;
                l = sums[1] - k;
                if(l == i || l == j || l == k || l < 0 || l > 9) continue;
                if(i + k != sums[2] || j + l != sums[3]) continue;
                if(i + l != sums[4] || j + k != sums[5]) continue;
                hasSol = true;
                break;
            }
            if (hasSol) break;
        }
        
        if (!hasSol) {
            System.out.print(-1);
            return;
        }

        System.out.println(i + " " + j);
        System.out.print(k + " " + l);
    }
    
    public static int[] readInts() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[6];
        try {
            for(int i = 0; i < 3; i++) {
                String line = reader.readLine();
                String[] splitted = line.split(" ");
                numbers[i*2] = Integer.parseInt(splitted[0]);
                numbers[i*2+1] = Integer.parseInt(splitted[1]);
            }
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}