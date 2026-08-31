import java.lang.*;
import java.util.*;

public class solution{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        scan.nextLine();
        String arr = scan.nextLine();
        int count = 0;
        for(int i = 0; i < x; i++){
            if(arr.charAt(n-1-i) == '1'){
                count++;
            }
        }
        if(arr.charAt(n-1-y) == '1'){
            count--;
        }else{
            count++;
        }
        System.out.println(count);
    }
}