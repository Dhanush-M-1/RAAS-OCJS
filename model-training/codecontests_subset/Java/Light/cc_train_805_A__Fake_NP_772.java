import java.util.Scanner;
public class omar{
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int x=sc.nextInt();
        int y=sc.nextInt();
        if(x==y){
            System.out.println(x);
        }
        else{
            System.out.println(2);
        }
    }
}