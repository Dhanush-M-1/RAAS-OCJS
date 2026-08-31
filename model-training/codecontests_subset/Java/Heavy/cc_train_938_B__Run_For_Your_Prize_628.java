import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] vet = new int[n];
        float average = 500000.5f;
        float temp;
        float min = average;
        int pos = 0;

        for (int i = 0; i < vet.length; i++){
            vet[i] = scanner.nextInt();
            temp = Math.abs(vet[i]-average);
            if (temp < min){
                min = temp;
                pos = i;
            }
        }
        if (vet[pos] > average){
            System.out.println(1000000-vet[pos]);
        }
        else
            System.out.println(vet[pos]-1);
    }
}