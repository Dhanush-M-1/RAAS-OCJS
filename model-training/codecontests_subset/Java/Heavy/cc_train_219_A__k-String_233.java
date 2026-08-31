import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException{
        try (   PrintWriter printWriter = new PrintWriter(System.out);
                Scanner scanner = new Scanner(System.in)
                ){
            int k = scanner.nextInt();
            String s = scanner.next();
            int a[] = new int [26];
            for (int i = 0; i < s.length(); i++) {
                a[s.charAt(i) - 'a']++;
            }
            String temp = "";
            for (int i = 0; i < 26; i++) {
                if (a[i] % k != 0){
                printWriter.print(-1+"\n");
                return;
                }
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < a[i] / k ; j++) {
                    temp+= (char)('a' + i);
                }
            }
            for (int i = 0; i < k; i++) {
                printWriter.print(temp);
            }
            printWriter.print("\n");
        }
    }
    
}