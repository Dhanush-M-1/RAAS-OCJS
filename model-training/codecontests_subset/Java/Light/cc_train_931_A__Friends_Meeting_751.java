import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // write your code here
        double PI=3.1415926535897932384626433;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d= Math.abs(b-a);
        int res=0;
        if(d%2==0){
            res= (d/2)*(d/2+1)/2;
            res*=2;
        }
        else{
            res+=(d/2)*(d/2+1)/2;
            res+=(d/2+1)*(d/2+2)/2;
        }
        System.out.println(res);

    }
}