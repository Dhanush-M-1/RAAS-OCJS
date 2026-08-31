import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // input
        int num = scan.nextInt();
        int count = 0;
        int answer = 0;
        for(int i = 1; i <= num; i++){
            if(scan.nextInt() == i){
                count++;
            } else {
                answer += (count + 1) / 2;
                count = 0;
            }
        }
        if(count > 0){
            answer += (count + 1) / 2;
        }

        // answer
        System.out.println(answer);
    }
}