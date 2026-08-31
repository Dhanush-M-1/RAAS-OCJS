import java.util.Scanner;

/**
 * Created by Ehsan on 3/5/2016.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=0,ans=0;
        while(sc.hasNext()){
            String s=sc.nextLine();
            if(s.charAt(0)=='+')num++;
            else if(s.charAt(0)=='-')num--;
            else{
                int i=0;
                while(s.charAt(i)!=':')i++;
                ans+=num*(s.length()-i-1);
            }
            //System.out.println(ans);
        }
        System.out.println(ans);
    }

}
