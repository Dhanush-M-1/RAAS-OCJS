import java.util.Scanner;

public class Codepractis {

    
    public static void main(String[] args) {
    
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
       
        char[] arr = new char[str.length()];
        for(int i = 0 ; i <str.length();i++){
            arr[i]=str.charAt(i);
        }
        for(int i = 0 ; i<arr.length;i+=2){
          for(int j =i+2 ;j<arr.length;j+=2){
              if(arr[i]>arr[j]){
                  char temp = arr[i];
                  arr[i]=arr[j];
                  arr[j]=temp;
              }
          }
        }
        for(int i = 0 ; i <arr.length;i++){
            System.out.print(arr[i]);
        }
        
           
        
        
        
        
        
        
    }
    
}