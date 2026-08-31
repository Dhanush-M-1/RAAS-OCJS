import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str1=s.next();
        String str2=s.next();
        long n = Long.parseLong(str1);
        long p = Long.parseLong(str2);
        long w=s.nextInt();
        long d=s.nextInt();
        boolean flag=true;
        long x=0;
        long y=0;
        long z=0;
        long p1=p;
        if((p==0 || p>=d) && n*w>=p1){
            x=p1/w;
            p1=p1%w;
            if(p1>0){
                y=p1/d;
                p1=p1%d;
                if(p1>0 && w%d!=0){
                    for(int i=1;i<100000;i++){
                        if((i*w+p1)%d==0){
                            x-=i;
                            y=y+(i*w+p1)/d;
                            p1=(i*w+p1)%d;
                            break;
                        }
                    }
                }
                else if(p1!=0){
                    flag=false;
                }
            }
            z=n-x-y;
        }
        else{
            flag=false;
        }
        if(!flag){
            System.out.println("-1");
        }
        else{
            System.out.println(x+" "+y+" "+z);
        }
        
    }
}
  	 	   	 			  	   	     	  		