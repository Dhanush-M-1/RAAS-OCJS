import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();
        char[]ch = sc.next().toCharArray();
        int i;
        for( i=1;i<ch.length;i++){
            if(ch[i-1]>ch[i]){
                break;
            }
        }
        if(i==n){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
            System.out.println(i+" "+(i+1));
        }

    }
}