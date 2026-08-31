

import java.util.Arrays;
import java.util.Scanner;

public class B {
public static void main(String cd[]){
    Scanner in=new Scanner(System.in);
    String a=in.next();
    String b=in.next();
    String c=in.next();
    int aa[]=new int[200];
    int bb[]=new int[200];
    int cc[]=new int[200];
    for(int i=0;i<a.length();i++){
        aa[a.charAt(i)]++;
    }
    for(int i=0;i<b.length();i++){
        bb[b.charAt(i)]++;
    
    }
    for(int i=0;i<c.length();i++){
        cc[c.charAt(i)]++;
    }
    int fb=Integer.MAX_VALUE;
    for(int i=0;i<200;i++){
        if(bb[i]!=0){
        int obt=aa[i]/bb[i];
        if(fb>obt){
            fb=obt;
        }
        }
    }
    int ans=0;
    int bs=0,cs=0;
    int as[]=new int[200];
    for(int i=0;i<=fb;i++){
        int temp[] =Arrays.copyOf(aa,aa.length);
        for(int j=0;j<200;j++){
            if(bb[j]!=0){
                temp[j]-=i*bb[j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<200;j++){
            if(cc[j]!=0){
                int obt=temp[j]/cc[j];
                if(obt<min){
                    min=obt;
                }
            }
        }
        
        if(ans<i+min){
            ans=i+min;
            bs=i;
            cs=min;
            as=temp;
        }
    }
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<bs;i++){
        sb.append(b);
    }
    for(int i=0;i<cs;i++){
        sb.append(c);
    }
    for(int i=0;i<200;i++){
        
        aa[i]-=bs*bb[i]+cs*cc[i];
        if(aa[i]!=0){
            for(int j=0;j<aa[i];j++){
                sb.append((char)i);
            }
        }
    }
    System.out.println(sb);
    
}
}
