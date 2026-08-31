
import java.util.Scanner;

/*

*/
public class A478 {
    public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
        int n = 0;
        for(int i=0;i<5;i++){
            int a = sc.nextInt();
            n+=a;
        }
        if(n!=0 && n%5==0)System.out.println(n/5);
        else System.out.println(-1);
    }    
}
