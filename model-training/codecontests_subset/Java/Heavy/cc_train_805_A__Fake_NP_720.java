
import java.util.Scanner;

public class Session {

    public static void main(String[] args) {
        int two =0, three = 0;
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        
        int r = in.nextInt();
        
        for (int i = l; i <= l+100; i++) {
                if(i % 2 == 0){
                     two++;
                }else if(i % 3 == 0){
                     three++;      
            }
        }

        if(l != r){
            if(three > two)
                System.out.println(3);
            else
                System.out.println(2);
        }else{
            System.out.println(l);
        }
    }

}
