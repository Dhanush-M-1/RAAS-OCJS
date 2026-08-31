import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AandBCompilationErrors {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        String[] array1 = br.readLine().split( " ");
        String[] array2 = br.readLine().split( " ");
        String[] array3 = br.readLine().split( " ");

        String output1="";
        String  output2 ="";
        Integer sum1=0;
        Integer sum2=0;
        Integer sum3=0;

        for(String str: array1) {
            sum1+=Integer.valueOf(str);
        }
        for(String str: array2) {
            sum2+=Integer.valueOf(str);
        }
        for(String str: array3) {
            sum3+=Integer.valueOf(str);
        }

        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }
}
