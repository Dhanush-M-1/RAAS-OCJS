import java.util.*;
public class BarkToUnlock {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String pass=s.next();
        int n=s.nextInt();
        String []ar=new String[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i]=s.next();
        }
        boolean flag=false;
        for(int i=0;i<ar.length;i++){
            String str=ar[i];
            for(int j=0;j<ar.length;j++){
                str+=ar[j];
                if(str.contains(pass)){
                    flag=true;
                    break;
                }
                str=ar[i];
            }
            if(flag)
                break;
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
}
