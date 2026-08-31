import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        
        try{
            BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
            String ln[] = new String[3];
            ln = input.readLine().split(" ");
            int a = Integer.parseInt(ln[0]);
            int b = Integer.parseInt(ln[1]);
            int c = Integer.parseInt(ln[2]);
            int result = 0;
            if(((a*c)-(b*c))%b==0){
                result = ((a*c)-(b*c))/b;
            }
            else{
                result = (((a*c)-(b*c))/b) + 1;
            }
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}