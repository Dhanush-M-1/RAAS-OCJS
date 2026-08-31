import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF1060A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String str = br.readLine();
        int maxTotalPos = n/11;
        int countEight = 0;
        for(int i=0;i<n;i++) {
            if(Character.getNumericValue(str.charAt(i)) == 8) {
                countEight++;
            }
        }
        int ans = Math.min(maxTotalPos,countEight);
        System.out.println(ans);
    }
}
