import java.util.Scanner;

public class Div3Q2Jun28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t!=0) {
            t--;
            long n = sc.nextLong();

            boolean impossible = false;
            long moves=0;
            while(n>1){

                boolean even = n%2==0;
                boolean by3 = n%3==0;
                if(even&&by3){
                    n=n/6;
                }
                else if(by3){
                    n*=2;
                }
                else{
                    System.out.println(-1);
                    impossible = true;
                    break;
                }
                moves++;
            }
            if(!impossible){
                System.out.println(moves);
            }
        }
    }

}
