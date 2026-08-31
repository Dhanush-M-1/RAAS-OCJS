
import java.util.Scanner;

public class phone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        int eights=0;
        if(length>=11){
            
            for(int i=0;i<length;i++){
                
                if(s.charAt(i)=='8'){
                    eights++;
                }
            }
            if((length/11)<eights){
                eights=length/11;
            }
            System.out.println(eights);
        }
        else{
            System.out.println(0);
        }
                
    }
}