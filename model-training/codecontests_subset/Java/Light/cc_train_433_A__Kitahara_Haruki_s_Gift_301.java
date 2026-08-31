
import java.util.Scanner;


public class KataharaHarukisGift433A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),cC=0,cD=0;
        for(int i=0;i<n;i++) {
            int a=sc.nextInt();
            if(a==100)cC++;else cD++;
        }
        boolean can = false;
        if(cC%2==0&&n>1) {
//            cD=cD+cC/2;//cD*2+cC
            if(cD%2==0)can=true;else if(cC>=2)can=true;
        }
        System.out.println(can?"YES":"NO");
    }
    
}
