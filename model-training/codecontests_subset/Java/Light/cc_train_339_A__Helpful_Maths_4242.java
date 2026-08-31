import java.util.*;
public class Main1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String b = scan.next();
        int x[] = new int[b.length()/2+1];
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)!='+')
                x[i/2] = b.charAt(i)-'0';
        }
        Arrays.sort(x);
        for(int j =0;j<b.length()/2+1;j++){
            if(j<b.length()/2)
                System.out.print(String.valueOf(x[j])+"+");
            else
                System.out.print(String.valueOf(x[j]));
        }
    }
}