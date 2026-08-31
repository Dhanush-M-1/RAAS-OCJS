import java.util.Scanner;

public class problemA {
    public static void main(String[] args){
        new problemA();
    }
    public problemA(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int max =0;
        int sum = 0;
        for(int i =0; i <n; i++){
            a[i] = sc.nextInt();
            sum += a[i];
            if (a[i]> max) max = a[i];
        }
        int electdesire = (int) 2*sum/n +1;
        System.out.println(electdesire > max ? electdesire: max);


    }

}