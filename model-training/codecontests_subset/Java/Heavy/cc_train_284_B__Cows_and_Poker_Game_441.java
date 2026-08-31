import java.util.Scanner;


public class cowspoker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = Integer.parseInt(scan.nextLine());
        String cows = scan.nextLine();
        int a = 0;
        int f = 0;
        int i = 0;
        for (int index = 0;index<k;index++){
            if (cows.charAt(index) == 'A'){
                a++;
            }
            if (cows.charAt(index) == 'F'){
                f++;
            }
            if (cows.charAt(index) == 'I'){
                i++;
            }
        }
        if (i > 1){ 
            System.out.println(0);
        }
        if (i == 1){
            System.out.println(1);
        }
        if (i == 0){
            System.out.println(a);
        }
    }
}
