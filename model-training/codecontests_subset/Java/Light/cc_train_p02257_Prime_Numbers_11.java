import java.util.Scanner;

/**
 * A3
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        int result = 0;
        for(int i=0; i<len; i++){
            if(check(sc.nextInt())){
                result++;
            }
        }
        sc.close();
        System.out.println(result);
    }

    private static Boolean check(int n){
        int max = (int)Math.sqrt(n);
        for(int i=2; i<=max; i++){
            if(n%i == 0){
               return false;
            }
        }
        return true;
    }
}
