import java.util.Scanner;
public class test19{
    public static int testCase19(int L,int r,int d) {
        return (r%d==0)?r+d:r+d-r%d;
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int t=input.nextInt();
        for (int i = 0; i < t; i++) {
         int L= input.nextInt();
         int r = input.nextInt();
         int d = input.nextInt();
          System.out.println((d<L||d>r)?d:testCase19(L,r,d));
        }
       
    }
}