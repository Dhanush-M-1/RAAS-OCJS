import java.util.*;

public class A_sol{
    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        sn.nextLine();
        String input = sn.nextLine();
        char [] arr = input.toCharArray();
        int one=0, zero=0;
        for(int i=0; i<n; i++){
            if(arr[i]=='0') zero++;
            else one++;
        }
        if(one!=zero){
            System.out.println(1);
            System.out.println(input);
            return;
        }
        System.out.println(2);
        System.out.println(input.substring(0,n-1)+" "+input.charAt(n-1));
    }
}