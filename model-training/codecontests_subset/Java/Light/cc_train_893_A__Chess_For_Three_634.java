import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sahil on 22/12/17.
 */
public class Main {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(reader.readLine());
            int spec[] = new int[num];
            int arr[] = new int[num];
            for(int i=0;i<num;i++){
                arr[i] = Integer.parseInt(reader.readLine());
            }
            spec[0] = 3;
            boolean isCorrect = true;
            for(int i=0;i<num;i++){
                if(arr[i] != spec[i]){
                    if(i != num-1){
                        spec[i+1] = 6-arr[i]-spec[i];
                    }
                }
                else{
                    isCorrect = false;
                    break;
                }
            }

            if(isCorrect){System.out.println("YES");}
            else{
                System.out.println("NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
