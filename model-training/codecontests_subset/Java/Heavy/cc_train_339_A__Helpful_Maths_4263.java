
import java.util.Scanner;
public class cf39A {
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for (int i = 0;i<input.length();i++){
            if (input.charAt(i) == '1')
                one++;
            if (input.charAt(i) == '2')
                two++;
            if (input.charAt(i) == '3')
                three++;
        }
        
        String out = "";
        while ((one + two + three) > 0){
            if (one != 0){
                out += "1";
                one--;
                if ((one + two + three) > 0)
                    out += "+";
                
                continue;
            }
            
            if (two != 0){
                out += "2";
                two--;
                if ((one + two + three) > 0)
                    out += "+";
                
                
                continue;
            }
            
            if (three != 0){
                out += "3";
                three--;
                if ((one + two + three) > 0)
                    out += "+";
                
                
                continue;
            }
            
        }
        
        System.out.println(out);
        
    }
}
