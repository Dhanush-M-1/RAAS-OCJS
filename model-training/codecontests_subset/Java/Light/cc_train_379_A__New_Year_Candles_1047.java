import java.util.Scanner;
public class main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt(),res=0;
        res=a+((a-1)/(b-1));
        System.out.print(res);
    }
}
