import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int count = 0;
            boolean cant = true;
            while(cant){
                if(b==0) break;
                if (b>=1 && c >= 2 ){
                    b-=1;
                    c-=2;
                    count+= 3;
                }
                else if (a>=1 && b>=2){
                    a-= 1;
                    b-= 2;
                    count += 3;
                }
                else break;
            }
            System.out.println(count);
        }
    }
}
