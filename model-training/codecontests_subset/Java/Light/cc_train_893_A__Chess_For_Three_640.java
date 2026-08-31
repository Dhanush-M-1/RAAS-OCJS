import java.util.Scanner;

public class shah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a = 3,b,c=2;
        for (int i = 0; i < n; i++) {
            b = in.nextInt();
            if(b==a){
                c=0;
            }
            if(b==1){
                if(a == 3){a = 2;}
                else{a = 3;}
            }
            if(b==2){
                if(a == 3){a = 1;}
                else{a = 3;}
            }
            if(b==3){
                if(a == 1){a = 2;}
                else{a = 1;}
            }
            if(i == n-1 && c==2){
                c=1;
            }
        }
        if(c == 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
