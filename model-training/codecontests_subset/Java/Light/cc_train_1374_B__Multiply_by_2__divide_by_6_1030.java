import java.util.Scanner;
public class Main {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        long T = s.nextLong();
        for(long i=1; i<=T; i++){

            long num = s.nextLong();
            int count = 0;

            while(num!=1){

                if(num%6==0){
                    num = num/6;
                    count++;
                }
                else if(num%3==0){
                    num = num*2;
                    count++;
                }
                else{
                    count = -1;
                    break;
                }
            }

            System.out.println(count);
        }
    }
}