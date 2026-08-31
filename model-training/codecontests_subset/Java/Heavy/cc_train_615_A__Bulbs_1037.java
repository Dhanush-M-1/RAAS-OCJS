import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Bulbs_338A {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int n = new Integer(s.nextToken());
        int m = new Integer(s.nextToken());
        boolean [] bulbs = new boolean[m+1];
        Arrays.fill(bulbs, false);
        for (int i = 0; i < n; i++) {
            String [] input = br.readLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                bulbs[new Integer(input[j])] = true;
            }           
        }
        boolean flag = true;
        for (int i = 1; i < bulbs.length; i++) {
            if(!bulbs[i]){
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }

}
