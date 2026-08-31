import java.io.*;
public class Solution {
    public static void main(String []ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int not = Integer.parseInt(br.readLine());
        while(not--!=0) {
            String input[] = br.readLine().split(" ");
            int b = Integer.parseInt(input[0]);
            int p = Integer.parseInt(input[1]);
            int q = Integer.parseInt(input[2]);
            if(q%3 == 0) {
                System.out.println(b);
            }
            else if (q%3 == 1){
                System.out.println(p);
            }
            else
                System.out.println(p^b);

        }
    }
}