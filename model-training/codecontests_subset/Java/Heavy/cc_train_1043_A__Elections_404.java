import java.util.Scanner;


public class Main {


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int value[] = new int[n];
        int sum = 0;
        int max = 0;
        for(int i =0;i<n;i++){
            value[i]=scanner.nextInt();
            sum+=value[i];
            if(max<value[i]){
                max = value[i];
            }
        }
        while(true){
            int search = 0;
            for(int i = 0;i<n;i++){
                search+=max-value[i];
            }
            if(search>sum){
                System.out.println(max);
                break;
            }
            max++;
        }




    }
}