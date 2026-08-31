
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madis
 */
public class Chat {

    public static void main(String[] args) {
        long memmory = 0;
        long count = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            if(str.startsWith("-")){
                count--;
            }else if(str.startsWith("+")){
                count++;
            }else{
                String msg = str.substring(str.indexOf(":"));
                if(msg!=null && !msg.equals("")){
                    memmory+=(msg.length()-1)*count;
                }
            }
        }

        System.out.println(memmory);
    }
}
