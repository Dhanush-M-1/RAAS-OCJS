import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] data = new int[num];
        for(int i=0;i<num;++i){
            data[i] = sc.nextInt();
        }
        int count = 0;
        for(int i=0;i<num;++i){
            count += (i+1);
            if(count >= k){
                //System.out.print(i);
                System.out.print(data[i-(count-k)]);
                break;
            }
        }
    }
}