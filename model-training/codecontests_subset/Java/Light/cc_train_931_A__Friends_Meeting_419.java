        import java.util.*;

        public class arr {

            public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
int a=scn.nextInt();
int b=scn.nextInt();
int mova=0,movb=0;
int tiredness=0;
if(a>b){
    int tmp=a;
    a=b;
    b=tmp;
}
while(a!=b){
    if(mova==movb){
        a+=1;
        mova+=1;
        tiredness+=mova;
    }else if(mova>movb){
        b-=1;
        movb+=1;
        tiredness+=movb;
    }else{
        a+=1;
        mova+=1;
        tiredness+=mova;
    }
}
System.out.println(tiredness);
}
        }

                        