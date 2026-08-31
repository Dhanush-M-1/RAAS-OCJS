import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AAndBAndCompilationErrors {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int[] first = new int[n];
        int[] second = new int[n - 1];
        int[] third = new int[n - 2];
        for(int i = 0 ; i < n - 2 ; i++) {
            first[i] = Integer.parseInt(st.nextToken());
            second[i] = Integer.parseInt(st2.nextToken());
            third[i] = Integer.parseInt(st3.nextToken());
        }
        first[n - 2] = Integer.parseInt(st.nextToken());
        second[n - 2] = Integer.parseInt(st2.nextToken());
        first[n - 1] = Integer.parseInt(st.nextToken());
        Arrays.sort(first);
        Arrays.sort(second);
        Arrays.sort(third);
        boolean found = false;
        for(int i = 0 ; i < n - 1; i++) {
            if(first[i] != second[i]) {
                found = true;
                System.out.println(first[i]);
                break;
            }
        }
        if(!found)
            System.out.println(first[n - 1]);
        found = false;
        for(int i = 0 ; i < n - 2 ; i++) {
            if(second[i] != third[i]) {
                found = true;
                System.out.println(second[i]);
                break;
            }
        }
        if(!found)
            System.out.println(second[n - 2]);
    }
}
