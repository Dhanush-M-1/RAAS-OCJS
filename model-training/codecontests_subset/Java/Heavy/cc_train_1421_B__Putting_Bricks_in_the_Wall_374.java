import java.io.IOException;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s1 = sc.next();

                for (int j = 0; j < n; j++) {
                    arr[i][j] = s1.charAt(j);
                }
            }
            char x=arr[0][1];
            char y=arr[1][0];
            char u=arr[n-2][n-1];
            char v=arr[n-1][n-2];

            if(x==y && u==v && x==u){
                System.out.println(2);
                System.out.println("1 2");
                System.out.println("2 1");
            }else if(x==u && y==v && x!=y){
                System.out.println(2);
                System.out.println("1 2");
                System.out.println((n) +" " + (n-1));
            }else if(x==v && y==u && x!=y){
                System.out.println(2);
                System.out.println("1 2");
                System.out.println((n-1) +" " + (n));
            }else if(x==y && x==u && x!=v){
                System.out.println(1);
                System.out.println((n-1)+" "+ (n));
            }else if(x==y && x==v && x!=u){
                System.out.println(1);
                System.out.println((n)+" "+ (n-1));
            }else if(u==y && u==v && u!=x){
                System.out.println(1);
                System.out.println("2 1");
            }else if(x==u && x==v && x!=y){
                System.out.println(1);
                System.out.println("1 2");
            }else{
                System.out.println(0);

            }
        }
    }
}