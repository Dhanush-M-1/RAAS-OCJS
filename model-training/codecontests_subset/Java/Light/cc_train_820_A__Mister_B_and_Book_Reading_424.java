
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        
        int c=in.nextInt();
        int v0=in.nextInt();
        int v1=in.nextInt();
        int a=in.nextInt();
        int l=in.nextInt();
        int count=1;
        c=c-v0;
        while(c>0)
        {
            if((v0+(a*count))<=v1){
                c=(c-(v0+(a*count)-l));
            }
            else{
                c=c-(v1-l);
            }
            count++;
        }
        System.out.println(count);
    }
}
