
import java.util.Scanner;

public class Watermelon {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        sc.nextLine();
        String m=sc.nextLine();
        char[] c;
         c = m.toCharArray();
        if(n>=11){
                    int count=0;

            for(int i=0;i<c.length;i++){
            if('8'==c[i]){
                count++;
            }
            }
             
            if(count>=(n/11)){
            System.out.println(n/11);
            
            }
            else
                System.out.println(count);
            
        }
      else
         System.out.println("0");
        
    }

}
