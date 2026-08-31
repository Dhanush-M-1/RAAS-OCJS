import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int i, j, n = scanner.nextInt();
        int count = 0;
        
        for(i = 0; i < n; ++i){
            int input = scanner.nextInt();
            int root = (int)Math.sqrt(input);
            for(j = 2; j <= root; ++j) if(input%j == 0) break;
            if(j == root + 1 || input == 2) ++count;
        } 
        System.out.println(count);
        scanner.close();
    }
}
