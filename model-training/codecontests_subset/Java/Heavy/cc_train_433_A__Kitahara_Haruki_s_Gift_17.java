import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        String scorer = br.readLine();
        String[] apples = scorer.split(" ");
        Arrays.sort(apples);
        int a = 0;
        int b = 0;
        int total = 0;
        int hundred = 0;
        int twoHundred = 0;
        for(int i = 0; i < apples.length; i++){
            int value = Integer.parseInt(apples[i]);
            total += value;
            if(value == 100)
                hundred += 1;
            else{
                twoHundred += 1;
            }
            
        }
        if ( (hundred == 0  || twoHundred == 0) && number% 2 !=0 ){
            System.out.println("NO");
            return;
        }
        
        if((total/100 % 2) == 0 && hundred % 2 == 0  && number >= 2)
            System.out.println("YES");
        else{
            System.out.println("NO");
        }
    }
}
