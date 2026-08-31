import java.util.Scanner;
public class WizardANDDEMOS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        
        double d=((double)y/100.0)*(double)n;
        //System.out.println(d);
        int d1=(int)d;
        if(d>d1)
        {
            d1=d1+1;
        }
        if(x>d1)
        {
            System.out.println("0");
            return;
        }
        System.out.println(Math.abs(x-d1));
    }
}
