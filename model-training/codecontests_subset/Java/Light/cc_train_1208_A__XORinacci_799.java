import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for(int i = 0; i < T;i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            if(n % 3 == 0){
                System.out.println(a);
            }else if(n % 3 == 1){
                System.out.println(b);
            }else{
                System.out.println(a^b);
            }
        }

    }
}
