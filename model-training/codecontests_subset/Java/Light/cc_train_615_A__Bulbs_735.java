import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.util.HashSet;
import java.lang.Integer;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        HashSet set = new HashSet();
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i=0; i<n; i++){
            int k = scan.nextInt();
            for(int j=0; j<k; j++)set.add(scan.nextInt());
        }
        System.out.println(set.size()==m?"YES":"NO");
        
    }
}