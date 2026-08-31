import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class round36 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int size = sc.nextInt();
        int num2[] = new int[num];
        int mxm=0;
        int count=0;
        for(int i=0; i<num; i++){
            num2[i]=sc.nextInt();
        }
        for(int i=0;i <num2.length; i++){
            if(size%num2[i]==0){
                num2[count]=num2[i];
                count++;
            }
        }
        int num3[] = new int[count];
        for(int i=0; i<count;i++){
            num3[i]=num2[i];
        }
        Arrays.sort(num3);
        System.out.println(size/num3[num3.length-1]);
    }
}
