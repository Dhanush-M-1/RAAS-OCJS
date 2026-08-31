import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class two_gram {

    public static int get_count(char str[], char substr[], int strlen){
        int count = 0;

        for (int i=0; i<strlen-1; i++) {
            if((str[i] == substr[0]) && (str[i+1] == substr[1])){
                count+=1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int strlen = Integer.parseInt(reader.readLine());
        String string = reader.readLine();
        // Scanner scanner1 = new Scanner(System.in);
        // Scanner scanner2 = new Scanner(System.in);

        // int strlen = scanner1.nextInt();
        // String string = scanner2.nextLine();
        // System.out.print(string);
        char str[] = string.toCharArray();
        int max = 0;
        int count = 0;
        String value = "";
        for (int j=0; j<strlen - 1; j++) {

            char[] substr = Arrays.copyOfRange(str, j, j+2);
            // System.out.println( String.valueOf(substr));
            count = get_count(str, substr, strlen);
            if(count > max) {
                max = count;
                value = String.valueOf(substr);
            }
            
            // System.out.print(j);
        }
        System.out.println(value);
        
   }
}