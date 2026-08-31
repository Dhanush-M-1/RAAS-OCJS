import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemA {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numero_casos = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numero_casos; i++) {
            String [] line = reader.readLine().split(" ");
            int piedras_a = Integer.parseInt(line[0]);
            int piedras_b = Integer.parseInt(line[1]);
            int piedras_c = Integer.parseInt(line[2]);
            int piedras_quitadas = 0;
            if(piedras_b != 0){
                while(piedras_c >= 2 && piedras_b >= 1){
                    piedras_b -= 1;
                    piedras_c -= 2;
                    piedras_quitadas += 3;
                }
                while(piedras_b >= 2 && piedras_a >= 1){
                    piedras_a -= 1;
                    piedras_b -= 2;
                    piedras_quitadas += 3;
                }
            }
            System.out.println(piedras_quitadas);
        }
    }
}
