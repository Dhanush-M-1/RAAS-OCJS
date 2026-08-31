import java.util.*;
import java.util.Scanner;

public class Woof{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.next();
        int n = scanner.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scanner.next();
        }for(int k=0;k<n;k++){
            for(int j=0;j<n;j++){
                String ran = words[k]+words[j];
                if(ran.contains(inp)){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}