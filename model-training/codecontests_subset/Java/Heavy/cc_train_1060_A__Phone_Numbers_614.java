import java.io.IOException;
import java.util.Scanner;

public class a {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       String koll=sc.nextLine();
       int kol=Integer.valueOf(koll);
       String n=sc.nextLine();

       String[] f=n.split("");
       int a[]=new int[10];
       int result=0;


       for(int i =0;i<kol;i++){
       if(Integer.valueOf(f[i])==0){
           a[0]++;
       }
           if(Integer.valueOf(f[i])==1){
               a[1]++;
           }
           if(Integer.valueOf(f[i])==2){
               a[2]++;
           }
           if(Integer.valueOf(f[i])==3){
               a[3]++;
           }
           if(Integer.valueOf(f[i])==4){
               a[4]++;
           }
           if(Integer.valueOf(f[i])==5){
               a[5]++;
           }
           if(Integer.valueOf(f[i])==6){
               a[6]++;
           }
           if(Integer.valueOf(f[i])==7){
               a[7]++;
           }
           if(Integer.valueOf(f[i])==9){
               a[9]++;
           }
           if(Integer.valueOf(f[i])==8){
               a[8]++;
           }
       }
      result=a[8];

      if(a[8]==1){
          result=1;
      }

           while(result*11>kol){

               result=result-1;
           }


       if(kol<11){
           result=0;
       }
        echo(result+"");


    }
    public static void echo(String a){
        System.out.println(a);
    }
}