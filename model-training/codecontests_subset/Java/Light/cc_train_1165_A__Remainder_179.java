import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt(),x=cin.nextInt(),y=cin.nextInt();
        String str=cin.next();
        char[]st=str.toCharArray();
        int sum=0;
        for(int i=(n-x);i<(n-y-1);i++){
            if(st[i]=='1')sum++;
        }
        if(st[n-y-1]=='0')sum++;
        for(int i=(n-y);i<st.length;i++){
            if(st[i]=='1')sum++;
        }
        System.out.println(sum);
    }
}
