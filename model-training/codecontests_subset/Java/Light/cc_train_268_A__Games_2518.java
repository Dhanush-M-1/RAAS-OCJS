import java.util.Arrays;
import java.util.Scanner;
public class first {

    public static void main(String[] args) {

        int count = 0;
        Scanner input = new Scanner(System.in);

        int numberOfGames = input.nextInt();
        int arr1[] = new int[numberOfGames];
        int arr2[] = new int[numberOfGames];
        for (int i = 0;i<numberOfGames ;i++){
            arr1[i] = input.nextInt();
            arr2[i] = input.nextInt();}
        for (int i = 0; i< numberOfGames;i++){
            for (int j = 0 ; j<numberOfGames;j++){
                if (arr1[i] == arr2[j]){
                        count++;
                }
            }

        }
        System.out.println(count);

    }

}
