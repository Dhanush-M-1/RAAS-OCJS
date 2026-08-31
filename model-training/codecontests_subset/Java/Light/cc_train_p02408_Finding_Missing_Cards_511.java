import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] suit={"S","H","C","D"};
        Set<String> list = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        for (int i=0;i<4;i++) {
            for(int j=1;j<=13;j++){
                if(!list.contains(suit[i]+" "+j)){
                    System.out.println(suit[i]+" "+j);
                }
            }
        }
    }
}