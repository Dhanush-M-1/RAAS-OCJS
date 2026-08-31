
import java.util.Scanner;

public class ProblemB {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int i = 0; i < t; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int sum = 0;

            while(true){

                if(x > 0 && y > 1 && y/2 >= z/2){

                    x--;
                    y-=2;

                }else if(y > 0 && z > 1){

                    y--;
                    z-=2;

                }else{

                    break;
                }

                sum+=3;
            }

            System.out.println(sum);
        }
    }
}
