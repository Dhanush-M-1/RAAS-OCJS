import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Woodcutters {
    public static void m()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] locations = new int [n];
        int x = 0;
        int [] heights = new int [n];
        int h = 0;
        for (int i = 0; i < n; i++) {
            String [] a = (br.readLine()).split(" ");
            locations[x++] = Integer.parseInt(a[0]);
            heights[h++] = Integer.parseInt(a[1]);
        }
        System.out.println(helper(locations, heights , n));
    }
    public static int helper(int [] locations , int [] heights , int l){
        int count = 2;
        if(l <= 2){
            return l;
        }
        for (int i = 1; i < l-1; i++) {
            if(locations[i] - locations[i-1] > heights[i]){
                count++;
            }
            else if(locations[i+1] - locations[i] > heights[i]){
                count++;
                locations[i] += heights[i];
            }
        }       
        return count;
    }
    public static void main(String[] args) throws IOException {
        m();
    }
}
