import java.util.Scanner;

public class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            if(n%3==0){
                System.out.println(a);
                continue;
            }else if (n%3==1){
                System.out.println(b);
                continue;
            }
            else{
                System.out.println(a^b);
            }
        }
    }
}