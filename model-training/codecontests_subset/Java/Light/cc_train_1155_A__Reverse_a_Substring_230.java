import java.util.Scanner;
public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] input = scanner.nextLine().toLowerCase().toCharArray();
        for(int i = 0; i < n-1; i++){
            if(input[i] > input[i+1]){
                System.out.println("YES");
                System.out.printf("%d %d", i+1, i+2);
                return;
            }

        }
        System.out.println("NO");

    }
}
