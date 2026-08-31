import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long answer = 0;
        for(int i = 0; i < n; i++){
            answer += scan.nextInt();
            answer --;
        }
        System.out.println(answer);

    }
}
