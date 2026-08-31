import java.util.Scanner;

public class Codeforces1101A {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[]args){
        int number = SCANNER.nextInt();
        int [] array = new int[number];
        int [] array2 = new int[3];
        for(int j = 0;j<array.length;j++){
            for(int i = 0;i<array2.length;i++){
                array2[i]= SCANNER.nextInt();
                if(array2[2]<array2[0]){
                    array[j] = array2[2];
                }
                else{
                    array[j] = (array2[1]/array2[2]+1)*array2[2];
                }
            }
        }
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
