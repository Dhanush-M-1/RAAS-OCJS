import java.util.Scanner;

public class helpful{
  public static void main(String[] args){
    Scanner scr = new Scanner(System.in);
    int count =0;
      String  x = scr.nextLine();
      int i;
      int n = x.length();
      for(i=0;i<n;i+=2){
      if(x.charAt(i)=='1'){
        System.out.print('1');
        count+=2;
        if(count <n){
          System.out.print('+');
        }
      }
      
    }
    
    for(i=0;i<n;i+=2){
      if(x.charAt(i)=='2'){
        System.out.print('2');
        count+=2;
        if(count<n){
          System.out.print('+');
        }
      }
    }
    
    for(i=0;i<n;i+=2){
      if(x.charAt(i)=='3'){
        System.out.print('3');
        count+=2;
        if(count<n){
          System.out.print('+');
        }
      }
    }
    }
  }

  
  