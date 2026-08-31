import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num_Of_Elements = input.nextInt();


        for (int i = 0; i < num_Of_Elements; i++) {
            int arr[] = new int[3];
            for (int j = 0; j < 3; j++){
                arr[j] = input.nextInt();
            }
            if (arr[2]%3 == 0){
                System.out.println(arr[0]);
            }else if (arr[2] % 3 == 1){
                System.out.println(arr[1]);
            }else {
                System.out.println(arr[0]^arr[1]);
            }
        }

    }
}