import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Raspberry {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = scan.readLine().split("\\s");
        int n = Integer.parseInt(temp[0]);
        int c = Integer.parseInt(temp[1]);
        temp = scan.readLine().split("\\s");
        int today = Integer.parseInt(temp[0]);
        int tomorrow = 0;
        int raspberries = 0;
        for(int i = 1; i < n; i++){
            tomorrow = Integer.parseInt(temp[i]);
            if(today > tomorrow + c){
                if(raspberries < today - tomorrow - c) raspberries = today - tomorrow - c;
            }
            today = tomorrow;
        }
        System.out.println(raspberries);
    }
}