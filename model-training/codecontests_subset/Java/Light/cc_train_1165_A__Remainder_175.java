import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        String s=sc.next();
        int xVal= (int) Math.pow(10,x);
        int yVal= (int) Math.pow(10,y);
//        String s1= String.valueOf(xVal);
//        String s2=String .valueOf(yVal);
        int count=0;
        for (int i=n-x;i<n;i++){
            if (n-y-1==i){
                if (s.charAt(i)!='1') {
                    count++;
                }
            }else if (s.charAt(i)!='0'){
                count++;
            }
        }
        System.out.println(count);
    }
}
