import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pass = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] tries = new String[n];
        String result = "NO";
        for(int i = 0; i < n; i++) {
            tries[i] = br.readLine();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(pass.equals(tries[i]) || pass.equals(tries[j]) || pass.equals(tries[i].substring(1, 2) + tries[j].substring(0, 1) )
                        || pass.equals(tries[j].substring(1, 2)  + tries[i].substring(0, 1) )) {
                    result = "YES";
                    break;
                }
            }
        }
        System.out.println(result);
    }
}