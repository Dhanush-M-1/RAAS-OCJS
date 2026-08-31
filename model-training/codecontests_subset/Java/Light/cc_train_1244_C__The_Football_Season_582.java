import java.util.*;
import java.io.*;
public class ExtendedEcludian {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong(),p=sc.nextLong(),w=sc.nextLong(),d=sc.nextLong();
        boolean flag=false;
        long i=0;
        for(;i<w;i++){
            if(p-i*d<0)break;
            if((p-i*d)%w==0){
                flag=true;
                break;
            }
        }
        if(flag){
            if(n-i-((p-i)/w)<0) {
//                System.out.println(n+" "+i+" "+((p-i)/w));
                flag = false;
            }
        }
        System.out.println(flag?(p-i*d)/w+" "+i+" "+(n-((p-i*d)/w)-i):-1);
    }
}
