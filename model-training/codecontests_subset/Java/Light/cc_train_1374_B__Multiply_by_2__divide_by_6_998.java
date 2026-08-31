import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i <t ; i++) {
            int x = scan.nextInt();
            int count=0;
            boolean print = true;
            while (x>1) {
                int power = (int) (Math.log(x)/Math.log(6));
                if ((Math.pow(6, power))== x) {
                    System.out.println((int)(Math.log(x)/Math.log(6))+ count);
                    print=false;
                    break;
                }
                else if (x%3==0) {
                    x/=3;
                    count+=2;
                }
                else {
                    System.out.println(-1);
                    print=false;
                    break;
                }
            }
            if (print)System.out.println(count);
        }
        }
    }