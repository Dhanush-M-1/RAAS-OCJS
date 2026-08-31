
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int sum=0,temp;
        for(int i=0 ;i<5;i++){
            temp=input.nextInt();
            sum+=temp;
            }
        if(sum%5==0&&sum!=0){
            System.out.println(sum/5);
        }else{
            System.out.println(-1);
        }
    }
}

