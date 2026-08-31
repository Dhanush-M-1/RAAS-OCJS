import java.util.Scanner;

public class Apple2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int w = 0;
        int wa100 = 0, wa200 = 0;
        int wb100 = 0, wb200 = 0;

        for (int i = 1; i <= n; i++) {
            w = kb.nextInt();
            if (w == 100)
                wa100++;
            else
                wa200++;
        }

        int dif = wa200%2;
        if(dif==1){
            if(wa100%2==0 && wa100>0){
                System.out.print("YES");
            } else{
                System.out.print("NO");
            }
        } else{
            if (wa100 % 2 == 0) {
                System.out.print("YES");
            } else {
                System.out.print("NO");
            }
        }
    }
}