
import java.util.Scanner;


public class Xorinacci {
    
    public static void main(String[] args) {
        int a,b,n;
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int i=0;
        while(i<t){
            a=s.nextInt();
            b=s.nextInt();
            n=s.nextInt();
            if(n%3==0){
                System.out.println(a);
            }
            else if(n%3==1){
                System.out.println(b);
            }
            else{
                System.out.println(a^b);
            }
            
            i++;
        }
    }
}
