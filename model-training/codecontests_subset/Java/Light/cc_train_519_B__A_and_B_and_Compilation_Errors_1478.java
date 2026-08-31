import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scannercito = new Scanner(System.in);
        int lineas = scannercito.nextInt();
        int[] results = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < lineas-i; j++) {
                results[i]+= scannercito.nextInt();
            }
        }
        System.out.println(results[0]-results[1]);
        System.out.println(results[1]-results[2]);
        
    }// Aca termina tu main
}