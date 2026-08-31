
import java.util.Scanner;
public class WizardsAndDemonstrations {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double n=sc.nextInt();
        int x=sc.nextInt();
        double y=sc.nextInt();
        double need=Math.ceil(n*y/100);
        int ans;
        if(need<=x){
            ans=0;
        }
        else{
            ans=(int)need-x;
        }
        System.out.println(ans);
    }
}
