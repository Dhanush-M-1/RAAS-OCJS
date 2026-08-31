import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] brokens = new long[n+1];
        long[] ins = new long[n+1];
        for(int i = 0;i < m;i++){
            brokens[sc.nextInt()] = 1;
        }
        for(int i = 1;i < n + 1;i++){
            if(brokens[i] == 1){
                ins[i] = 0;
            }else if(i == 1){
                ins[i] = 1;
            }else if(i == 2){
                ins[i] = ins[i - 1] + 1;
            }else{
                ins[i] = ins[i - 1] + ins[i - 2];
                ins[i] = ins[i] % 1000000007;
            }
        }
        System.out.println(ins[n]);
    }
}