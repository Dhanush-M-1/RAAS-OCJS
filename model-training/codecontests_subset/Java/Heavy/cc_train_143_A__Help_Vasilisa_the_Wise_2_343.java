

import java.util.Scanner;


public class NewClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1=sc.nextInt(),r2=sc.nextInt(),c1=sc.nextInt(),c2=sc.nextInt(),d1=sc.nextInt(),d2=sc.nextInt();
        int[] s = new int[4];
        if ((d1-r2+c1)%2==0) {
           s[0]=(d1-r2+c1)/2;
        }
        if ((d2+r1-c1)%2==0) {
           s[1]=(d2+r1-c1)/2;
        }
        if (s[0]!=0) {
            s[2]=c1-s[0];
        }
        if (s[1]!=0) {
            s[3]=c2-s[1];
        }
        boolean b=s[0]==s[1]||s[0]==s[2]||s[0]==s[3]||s[1]==s[2]||s[1]==s[3]||s[2]==s[3];
        boolean f = s[0]<=9 &&s[1]<=9&&s[2]<=9&&s[3]<=9;
        if ((s[0]==0 ||s[1]==0 ||s[2]==0 ||s[3]==0)||b||!f) {
            System.out.println(-1);
        }
        else{
            System.out.println(s[0]+" "+s[1]+"\n"+s[2]+" "+s[3]);
        }
        
    }
}
