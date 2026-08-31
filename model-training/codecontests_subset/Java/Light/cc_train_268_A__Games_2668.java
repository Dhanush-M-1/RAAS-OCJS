import java.util.Scanner;
import java.util.Arrays;
public class Main 
{ 
public static void main(String[] args) 
{ 
    Scanner in=new Scanner(System.in);
    int team=in.nextInt();
    int home[]=new int[team];
    int guest[]=new int[team];
    for (int i = 0; i < team; i++) {
        home[i]=in.nextInt();
        guest[i]=in.nextInt();
    }
    int count=0;
    for (int i = 0; i < team; i++) {
        for (int j = 0; j < team; j++) {
            if(home[i]==guest[j]){
                count++;
            }
        }
    }
    System.out.println(count);
} 
}