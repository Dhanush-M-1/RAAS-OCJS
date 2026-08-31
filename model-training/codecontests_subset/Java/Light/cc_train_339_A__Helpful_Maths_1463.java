import java.util.Scanner;
public class Helpful_maths {

    
    public static void main(String[] args) {
       
       
       Scanner s = new Scanner(System.in);
       String str = s.next();
       int n=str.length();
        int []arr = new int[(n/2)+1];
        int j=0;
       for(int i=0;i<str.length();i++){
           
           if(Character.isDigit(str.charAt(i))){
               arr[j]=str.charAt(i);
               j++;
           }
       }
       int temp;
       for(int l=0;l<arr.length-1;l++){
           for(int k=l+1;k<arr.length;k++){
               if(arr[k]<arr[l]){
                   temp=arr[k];
                   arr[k]=arr[l];
                   arr[l]=temp;
               }
           }
       }
       int m=48;
        for(int i=0;i<arr.length;i++){
           arr[i]-=m;
       }
       System.out.print(arr[0]);
       for(int i=1;i<arr.length;i++){
           System.out.print("+" +arr[i]);
       }
    }
    
}
