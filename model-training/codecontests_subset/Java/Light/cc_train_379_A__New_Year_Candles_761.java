import java.util.Scanner;
public class Candles{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int s = n ;
        while(true){
            if(n/a>=1){
                s= s+(n/a);
                n = n/a + n%a;
            }else{
                break;
            }
        }
        System.out.print(s);

        }
    }