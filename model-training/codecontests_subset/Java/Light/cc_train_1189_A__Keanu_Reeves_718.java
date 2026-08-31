import java.util.Scanner;

/**
 * Created by Rukshar Alam on 12/12/2019.
 */
public class Reeves_1189A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);int n = sc.nextInt();sc.nextLine();
        String str = sc.nextLine();
        if(n%2==1){
            System.out.println("1");
            System.out.println(str);
        }
        else{
            int numOnes = 0;
            for(int i =0;i<n;i++){
                if(str.charAt(i)=='1') numOnes++;
            }

            int numZero = n-numOnes;
            if(numOnes!=numZero) {
                System.out.println("1");
                System.out.println(str);
            }else {
                System.out.println("2");
                System.out.print(str.substring(0,n-1)+" "+str.substring(n-1));
            }

        }
    }
}
