
import java.util.Scanner;

public class ChessForThree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int temp=1,a=1,b=2,spec=3,temp1;
        int ans=sc.nextInt();
        //temp=ans;
        if(ans==a || ans==b){
            for(int i=0;i<n-1;i++){
                if(ans==a){
                    a=ans;
                    temp1=b;
                    b=spec;
                    spec=temp1;
                }
                else{
                    b=ans;
                    temp1=a;
                    a=spec;
                    spec=temp1;
                }
                ans=sc.nextInt();
                if(ans==a || ans==b){
                    temp+=1;
                    //System.out.println("World");
                }
                else{
                    //System.out.println("Hello");
                    System.out.println("No");
                    //System.out.println("Hi");
                    break;
                }
            }
            if(temp==n){
                System.out.println("Yes");
            }
        }
        else{
            //System.out.println("Hello1");
            System.out.println("No");
        }
    }
}
