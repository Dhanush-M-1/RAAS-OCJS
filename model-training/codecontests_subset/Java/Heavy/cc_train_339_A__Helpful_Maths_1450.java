
import java.util.Scanner;

public class Bbbbbb {

    public static void main(String[] args) {
       String cad;
            Scanner lee=new Scanner(System.in);
            cad=lee.nextLine();
            
            for(int i=2; i<cad.length();i+=2){
                for(int j=i-2;j>=0;j=j-2){
                if(Integer.parseInt(cad.charAt(j+2)+"")<Integer.parseInt(cad.charAt(j)+"")){
                    if(i==2){
                        cad = cad.charAt(j+2)+"+"+cad.charAt(j)+cad.substring(j+3,cad.length());
                    }
                    else{
                    cad = cad.substring(0, j)+cad.charAt(j+2)+"+"+cad.charAt(j)+cad.substring(j+3,cad.length());}
                    
                }
                else{
                break;
                }
                }
            }
            System.out.println(cad);
    }
    
}