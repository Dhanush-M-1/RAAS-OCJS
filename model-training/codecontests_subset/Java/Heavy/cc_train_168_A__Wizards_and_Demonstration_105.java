import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        try{
            BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
            String in[] = new String[3];
            in = input.readLine().split(" ");
            double n = Integer.parseInt(in[0]);
            double x = Integer.parseInt(in[1]);
            double y = Integer.parseInt(in[2]);
            int min = (int)Math.ceil((y/100)*n);
            min -= x;
            if(min>=0){
                System.out.println(min);
            }
            else{
                System.out.println("0");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}