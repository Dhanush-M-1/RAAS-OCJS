import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Ques1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()), i;
        StringBuilder s = new StringBuilder(br.readLine());
        for (i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                System.out.println("YES");
                System.out.println(i+" "+(i+1));
                break;
            }
        }
        if(i==n){
            System.out.println("NO");
        }
    }
}
