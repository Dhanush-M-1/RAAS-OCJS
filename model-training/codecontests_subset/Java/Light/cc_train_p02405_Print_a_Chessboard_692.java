import java.util.Scanner;

class Main{
  private static int H,W;

  public static void main(String[] args){
    
    Scanner s= new Scanner(System.in);
   
   while(true){
   H=s.nextInt();
   W=s.nextInt();
   
   if(H==0&&W==0){
       break;
   }
   for(int i = 0;i<H;i++){
       
       for(int x=0;x<W;x++){
if(i%2==0){
      if(x%2==0){
   System.out.print("#");

}else { System.out.print("."); }

}
else{if(x%2==0){
System.out.print(".");

}else{  System.out.print("#");}



}
           
        
       }
       System.out.println("");
       
   }System.out.println("");
   
  }
  }   
  
  }
