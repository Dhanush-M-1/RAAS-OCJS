import java.util.Scanner;

public class ArrayList {
    public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int w=3;
            for (int i=0;i<n;i++){
                int a=sc.nextInt();
                if (w==a){
                    System.out.println("No");
                    return;
                }
                w=6-a-w;

            }
        System.out.println("Yes");

    }

    }