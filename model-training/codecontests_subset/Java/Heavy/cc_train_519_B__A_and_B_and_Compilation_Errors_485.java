import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int N = a.nextInt();
        int [] first = new int [N];
        int [] second = new int[N-1];
        int [] third = new int[N-2];
        int firstSum=0,secondSum=0,thirdSum=0;
        for(int i=0;i<N;i++){
            first[i]= a.nextInt();
            firstSum+=first[i];
        }
        for(int i=0;i<second.length;i++){
            second[i]= a.nextInt();
            secondSum+=second[i];
        }
        for(int i=0;i<third.length;i++){
            third[i]= a.nextInt();
            thirdSum+=third[i];
        }
        System.out.println(firstSum-secondSum);
        System.out.println(secondSum-thirdSum);
    }
}