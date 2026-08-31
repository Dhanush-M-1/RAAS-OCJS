import java.util.Scanner;
public class Binarysearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       int n =input.nextInt();
       input.nextLine();
       String a = input.nextLine();
       int count=0,start=0,def=0;
       for(int i=0;i<n;i++){
           if(a.charAt(i) != '*') continue;
           for(int j=i+1;j<n;j++){
               if(a.charAt(j) != '*') continue;
               def = j-i;
               for(int k=j;k<n && k<=(3*def)+j;k+=def){
                   if(a.charAt(k)== '*'){
                       count++;
                     // System.out.printf("%d\n",k);
                   }
                   else break;
                   if(count==4){
                       System.out.println("yes");
                     // System.out.printf("%d %d %d %d\n",i,j,k,def);
                       return;
                   }
               }
               count =0;
           }
       }
       System.out.println("no");
}
}