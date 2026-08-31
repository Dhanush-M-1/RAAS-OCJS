import java.util.*;
     
     
    public class Main {
        
        public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
          int min1,r1,r2,c1,c2,d1,d2, a1=0,a2=0,a3=0,a4=0;
          r1=input.nextInt();
          r2=input.nextInt();
          c1=input.nextInt();
          c2=input.nextInt();
          d1=input.nextInt();
          d2=input.nextInt();
        min1=Math.min(d1, c1);
        min1=Math.min(min1, r1);
            Set<Integer>s=new TreeSet<>();
        if(min1<10){
            a1=min1-1;
        }else{a1=9;}
        
        a4=d1-a1;
        
        a2=c2-a4;
        a3=r2-a4;
        boolean f=false;
        while(a1>0){
             a4=d1-a1;
        
        a2=c2-a4;
        a3=r2-a4;
        s.clear();
       
            if(a1<10&&a2<10&&a3<10&&a4<10){
               
            s.add(a1);s.add(a2);s.add(a3);s.add(a4);
        if(a1+a4==d1&&a1+a2==r1&&a1+a3==c1&&a2+a3==d2&&a2+a4==c2&&a3+a4==r2&&s.size()==4){
            
            f=true;
            
            break;   
        }else{
        a1--;
        }
        }
            else{
                a1--;
                }}
        
        if(f)
                System.out.println(a1+" "+a2+"\n"+a3+" "+a4);
        else
                System.out.println(-1);
        }
        
        
    }
    