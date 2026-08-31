
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        long[] data = new long[3];
        data[0] = input.nextLong();
        data[1] = input.nextLong();
        data[2] = input.nextLong();
        Arrays.sort(data);
        if((data[1]-data[0])%2==0){
            System.out.println(data[1]);
        }else{
            System.out.println(data[2]);
        }
    }
}