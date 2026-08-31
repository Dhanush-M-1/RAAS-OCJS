import java.util.Scanner;

public class ElectionsAwruk {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int runsum = 0;
        int max = 0;
        int n = sc.nextInt();
        for (int k = 0; k < n; k++){
            int next = sc.nextInt();
            runsum+=next;
            max = Math.max(max,next);
        }
        while (max <= 1000){
            if (max*n-runsum > runsum){
                System.out.print(max);
                break;
            }
            max++;
        }
    }
}
