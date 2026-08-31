

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        for (int i = 0; i < numQueries; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(solve(a,b, n));
        }
        scanner.close();
    }

    private static int solve(int a, int b, int n){
        if(n==0){
            return a;
        }
        if(n==1){
            return b;
        }
        int n1=a;
        int n2=b;
        int result=0;
        int v_2=-1, v_3=-1, v_4=-1;
        for (int i = 2; i <=4 ; i++) {
            result=n1^n2;
            n1=n2;
            n2=result;
           

            if(v_2==-1){
                v_2=result;
                continue;
            }
            if(v_3==-1){
                v_3=result;
                continue;
            }
            if(v_4==-1){
                v_4=result;
                continue;
            }
        }
        if(n%3==2){
            return v_2;
        }
        if(n%3==0){
            return v_3;
        }
        return v_4;
    }

}
