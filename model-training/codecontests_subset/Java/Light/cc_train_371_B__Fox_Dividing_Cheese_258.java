import java.util.Scanner;
public class FACprime {
public static Scanner in = new Scanner(System.in);
private static int A,B,C,D,U,O=1;
    public static void main(String[] args) {
        A=in.nextInt();A=prime(A);O=-1;B=in.nextInt();B=prime(B);
        if(A==B){System.out.println(Math.abs(C)+Math.abs(D)+Math.abs(U));}
        if(A!=B){System.out.println("-1");}
        
    }
    static int prime(int o)
    {while(o%2==0||o%3==0||o%5==0){
    if(o%2==0){while(o%2==0){C+=O;o/=2;}}
    if(o%3==0){while(o%3==0){D+=O;o/=3;}}
    if(o%5==0){while(o%5==0){U+=O;o/=5;}}}
        return o;
}
    
    
    
}