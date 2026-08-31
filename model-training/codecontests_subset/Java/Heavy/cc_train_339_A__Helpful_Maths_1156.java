import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Woodcutters {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        if(s.length()==1)
            System.out.println(s);
        else{
            int index=0;
            int[] x=new int[(s.length()/2)+1];
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    x[index]=s.charAt(i)-'0';
                    index++;
                }
            }
                Arrays.sort(x);
                for(int j=0;j<x.length-1;j++){
                    System.out.print(x[j]+"+");
                }
                System.out.print(x[x.length-1]);
            
        }
    }
}