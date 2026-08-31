import java.util.*;
class Main{

 public static void main(String args[]){
   
  try{
  int[] array = {1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};

  Scanner sc = new Scanner(System.in);
   
  int a = sc.nextInt();
   
  if(a >= 1 && a <= 32){
    System.out.println(array[a-1]);
  }  
  
  }catch(Exception e){
  }  
 }
}