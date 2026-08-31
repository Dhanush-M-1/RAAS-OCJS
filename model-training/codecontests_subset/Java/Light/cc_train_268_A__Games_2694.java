import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
int matchNum = scanner.nextInt();
int arr [][] = new int[matchNum][2];

        for (int i = 0; i < matchNum; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
int sum=0;
        for (int i = 0; i < matchNum-1; i++) {
            for (int j = i+1; j < matchNum; j++) {

                if(arr[i][0] == arr[j][1]) sum++;
                if (arr[i][1] == arr[j][0]) sum++;
            }
        }

        System.out.println(sum);
    }


}
