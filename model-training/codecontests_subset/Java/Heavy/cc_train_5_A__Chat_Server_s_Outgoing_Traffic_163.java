import java.util.HashMap;
import java.util.Scanner;

public class CF005A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long count = 0;
        long answer = 0;
        while(s.hasNext()){
            String str = s.nextLine();
            if(str.charAt(0) == '+' || str.charAt(0) == '-'){
                if(str.charAt(0) == '+'){
                    count++;
                }else{
                    count--;
                }
            }else{
                int indexOfColon = str.indexOf(":");
                int totalBytes = str.length() - indexOfColon - 1 ;
                answer += (count * totalBytes);
            }
        }
        System.out.println(answer);
    }
}
