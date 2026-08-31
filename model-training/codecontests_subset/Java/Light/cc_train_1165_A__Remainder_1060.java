import java.util.Scanner;

public class X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int col = 0;
        char[] ch = in.next().toCharArray();
        for (int i = n - a; i < n; i++) {
            if(i == n - b - 1){
                if(ch[i] == '0') {
                    col++;
                }
            }else if(ch[i] == '1'){
                col++;
            }
        }
        System.out.println(col);
    }
}
