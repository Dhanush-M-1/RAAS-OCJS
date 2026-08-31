
import java.util.HashSet;
import java.util.Scanner;

//package codeforce;
/* @author Kbk*/
public class Bulb {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//no.ofButtons
        int m=sc.nextInt();//no.ofBulbs
        HashSet has=new HashSet();
        for(int i=1;i<=n;i++){
            int noOfBulbs=sc.nextInt();
            for(int j=0;j<noOfBulbs;j++){
                has.add(sc.nextInt());
            }
        }
        if(has.size()==m)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
