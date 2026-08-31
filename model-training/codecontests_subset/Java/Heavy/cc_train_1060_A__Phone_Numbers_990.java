
import java.util.Scanner;


public class PhoneNumbers {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n;
        String ch="";
       
        do{
            
            //System.out.println("n = ");
            n = sc.nextInt();    
        }while ((n<1)||(n>100));
        
        do{
            
            //System.out.println("ch = ");
            ch = sc.next();
        }while ((ch.length()!=n)||(ch.indexOf(" ")!=-1)||(!ch.matches("[0-9]+")));
        
        if(ch.indexOf("8")==-1){
            System.out.println(0);
        }else{
            int numberOf8 = ch.length() - ch.replace("8", "").length();
            
            
            if (numberOf8 <= ch.length() / 11){
                System.out.println(numberOf8);
            }
            
            
            else{
                System.out.println(ch.length() / 11);
            }
            
        }
        
        
    }
    
}
