import java.io.*;
import java.util.*;
public class Q1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int z = 0; z < t; z++) {
            String str = br.readLine();
            char[]c = str.toCharArray();
            int count = 0;
            for(int i = 0; i<c.length-2;i++){
                char c1 = c[i];
                char c2 = c[i+1];
                char c3 = c[i+2];
                if(c1 == c3 && c2 == c3 && c1 != '*'){
                    c[i+1] = '*';
                    c[i+2] = '*';
                    count+=2;
                } else if(c1 == c3 && c1!='*'){
                    c[i+2] = '*';
                    count++;
                } else if(c1 == c2 && c2 != '*'){
                    c[i+1] = '*';
                    count++;
                } else if(c2==c3 && c2 != '*'){
                    c[i+2] = '*';
                    count++;
                }
            }
            if(c.length == 2 && c[0] == c[1])
                count = 1;
            System.out.println(count);
        }
    }
}