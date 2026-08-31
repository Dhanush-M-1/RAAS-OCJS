import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cf478a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <5 ; i++) {
            c[0]+=c[i];
        }

        if(c[0]%5==0 && c[0]!=0){
            System.out.println(c[0]/5);
        }else {
            System.out.println("-1");
        }
    }


}
