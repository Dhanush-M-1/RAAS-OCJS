import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            int result = n/11;
            int count = 0;

            for (int i = 0 ; i < line.length() ; i++){
                if (Integer.parseInt(Character.toString(line.charAt(i))) == 8){
                    count++;
                }
            }

            if (count > result){
                System.out.println(result);
            }
            else {
                System.out.println(count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
