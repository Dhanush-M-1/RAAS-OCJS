import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        boolean good = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int noSegments = Integer.parseInt(br.readLine());

        char[] segments  = br.readLine().toCharArray();

        for(int i = 0; i < noSegments; i++) {
            int j = 1;
            if (segments[i] == '*') {
                while (i + (j * 4) < noSegments) {

                    if (segments[i] == segments[i + j] &&
                            segments[i] == segments[i + (2*j)] &&
                            segments[i] == segments[i + (3 * j)] &&
                            segments[i] == segments[i + (4 * j)]) {

                        good = true;
                        break;
                    }
                    j++;
                }
            }

            if(good) {
                System.out.println("yes");
                break;
            }
        }

        if(!good) {
            System.out.println("no");
        }


    }
}
