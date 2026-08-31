import java.util.Scanner;

public class A {
    public static void main(String[]Args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int n = in.nextInt();
            int pas=0;
            int jug=0;
            boolean pos=true;
            for(int j=0; j<n; j++){
                int p = in.nextInt();
                int c = in.nextInt();
                if(pos){
                    int incc=c-pas;
                    int incp=p-jug;
                    pos=(incc<=incp&&incc>=0&&incp>=0&&c<=p);
                    pas=c;
                    jug=p;
                }
            }
            if(pos){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
