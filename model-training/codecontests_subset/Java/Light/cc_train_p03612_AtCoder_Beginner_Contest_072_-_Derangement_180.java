import java.util.Scanner;
//import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int N = sc.nextInt();
        int counter = 0;
        int [] in = new int [N];
        for (int i = 0; i < N; i++){
            in[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++){
            if(in[i] == i+1){
                counter++;
                if (i != N-1) {
                    int temp = in[i];
                    in[i] = in[i + 1];
                    in[i + 1] = temp;
                }
                else{
                    int temp = in[i];
                    in[i] = in[i-1];
                    in[i-1] = temp;
                }
            }
        }
        System.out.println(counter);
    }
}
