import java.io.*;
import java.util.StringTokenizer;
public class Pixels {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader inpt = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input;
        long n;
        try {
            input = new StringTokenizer(inpt.readLine());
            long[] rgb = {Long.parseLong(input.nextToken()),Long.parseLong(input.nextToken()),Long.parseLong(input.nextToken())};
            int j;
            n = Math.max(rgb[0], Math.max(rgb[1], rgb[2]));
            for(int i = 0; i < 3; i++){
                j = (i+1)%3;
                if( rgb[i]%2 == rgb[j]%2){
                    n = Math.min(n, Math.max(rgb[i], rgb[j]));
                }
            }
            System.out.println(n);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
