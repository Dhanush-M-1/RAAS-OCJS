import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String input = reader.readLine();
        int a[] = new int[300001];
        int ptr = 0;
        int f = 0,b = 0;
        a[ptr] = input.charAt(input.length() -1);
        for(int i = input.length() - 2;i>=0;i--){
            int temp = input.charAt(i);
            if(a[ptr] >= temp){
                ptr++;
                a[ptr] = temp;
            }
            else {
                f = n - ptr;
                b = i + 1;
                System.out.println("YES");
                break;

            }
        }
        if(b == 0 && f== 0){
            System.out.println("NO");
        } else {
            System.out.println(b + " " + f);
        }
    }
}
