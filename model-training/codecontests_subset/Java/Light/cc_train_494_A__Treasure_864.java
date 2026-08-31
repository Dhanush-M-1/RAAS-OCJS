import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by huangyi on 14-12-15.
 */
public class Main {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String word=s.nextLine();
        int left=0;
        int xx=0;
        int count=0;
        int last=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='('){
                left++;
            }else if(c==')'){
                left--;
                if(left<0){
                    System.out.println(-1);
                    return;
                }
            }else if(c=='#'){
                last=i;
                count++;
                left--;
                if(left<0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        int temp=0;
        for(int i=last+1;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='('){
                temp++;
            }else if(c==')') {
                temp--;
                if(temp<0){
                    temp=0;
                }
            }
        }
        if(temp>0){
            System.out.println(-1);
            return;
        }
        for(int i=0;i<count-1;i++){
                System.out.println(1);
        }
        System.out.println(1+left);

    }
}
