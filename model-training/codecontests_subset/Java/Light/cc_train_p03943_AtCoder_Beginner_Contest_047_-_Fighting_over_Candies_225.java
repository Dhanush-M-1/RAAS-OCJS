import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.next());
        int b = Integer.parseInt(scan.next());
        int c = Integer.parseInt(scan.next());

        if(a+b==c|b+c==a|a+c==b){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}