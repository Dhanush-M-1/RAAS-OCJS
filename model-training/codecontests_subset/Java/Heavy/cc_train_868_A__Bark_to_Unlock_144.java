import java.util.*;
import java.lang.*;
public class Bark {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        String pswd = scn.nextLine();
        int chances = scn.nextInt();
        ArrayList<String> bark = new ArrayList<String>();
        for(int i = 0; i <= chances; i++) {
            String temp = scn.nextLine();
            bark.add(temp);
        }

        for(int i = 0; i <= chances; i++) {
            String code = "";
            code += bark.get(i);
            String temp = code;
            for(int j = 0; j <= chances; j++) {
                code += temp+bark.get(j);
            }
            if(code.contains(pswd)){
                System.out.println("Yes");
                System.exit(0);
            }


        }
        System.out.println("No");





    }
}