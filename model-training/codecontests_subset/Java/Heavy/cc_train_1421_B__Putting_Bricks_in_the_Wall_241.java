
import java.util.Scanner;

public class PuttingBricksInWall {
    public static void main(String[] args) {
        int t;
        Scanner s = new Scanner(System.in);
        t = Integer.parseInt(s.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(s.nextLine());

            String[] d = new String[n];
            for(int i=0;i<n;i++)
            {
                d[i] = s.nextLine();
            }
            int a12,a21,bnn1,bn1n;
            a12 = d[0].charAt(1);
            a21 = d[1].charAt(0);

            bnn1 = d[n-1].charAt(n-2);
            bn1n = d[n-2].charAt(n-1);

            if(a12 == a21 && bnn1 == bn1n && a12 == bnn1) {
                System.out.println(2);
                System.out.println("1 2");
                System.out.println("2 1");

                continue;
            }
               else if(a12 == a21 && bnn1 == bn1n && a12 !=bnn1){
                System.out.println(0);
                continue;
            }

          else  if(a12 == a21 && bnn1 != bn1n)
            {
                System.out.println(1);
                if(bnn1 == a12){
                    System.out.println(n+" "+(n-1));
                }
                else System.out.println((n-1)+" "+n);
                continue;
            }

           else if(bnn1 == bn1n && a12 != a21)
            {
                System.out.println(1);
                if(a12 == bn1n){
                    System.out.println(1+" "+(2));
                }
                else System.out.println((2)+" "+1);
                continue;

            }
           else{
               System.out.println(2);

               if(a12 == bnn1){
                   System.out.println(n+" "+(n-1));
                   System.out.println("2 1");
               }

               else{
                   System.out.println((n-1)+" "+n);
                   System.out.println("2 1");
               }
            }

        }
    }
}