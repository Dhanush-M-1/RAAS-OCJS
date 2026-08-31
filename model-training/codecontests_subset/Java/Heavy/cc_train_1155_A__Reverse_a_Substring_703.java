import java.util.*;
import java.io.*;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //String[] buf = reader.readLine().split(" ");
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        for(int i=0;i<n-1;i++){
            if(s[i]<=s[i+1]) continue;
            char mid = s[i];
            s[i] = s[i+1]; s[i+1] = mid;
            System.out.println("YES");
            System.out.println(String.format("%d %d",i+1,i+2));
            return;
        }
        System.out.println("NO");
    }
}