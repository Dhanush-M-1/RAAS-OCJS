import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int j = 0;
        int [] arr = new int[n*2];
        int sum = 0;

        for(int i = 0; i < n*2; i++){
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < n*2 - 2 ; i++){
            if(i % 2 == 0)
                j = i + 3;
            else
                j = i + 1;

            while (j < n*2){
                if(arr[i] == arr[j])
                    sum++;
                j+=2;
            }

        }

        System.out.println(sum);

        in.close();
    }

}