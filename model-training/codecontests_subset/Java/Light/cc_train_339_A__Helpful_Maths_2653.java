import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        int i =0,k,temp;
        int[] arr = new int[100];
        String arr2;
                char a;
        
        Scanner input = new Scanner(System.in);
        arr2 = input.nextLine();
//        System.out.println(arr2);
         
         for(i=0,k=0;i<arr2.length();i=i+2,k++)
         {
            a  = arr2.charAt(i);
            arr[k]= Integer.parseInt(String.valueOf(a));
         }
         int min = arr[0];
         for(int j=0;arr[j]!=0;j++)
         {
             for(int l=j+1;arr[l]!=0;l++)
             {
                 if(arr[j]>arr[l])
                 {
                     temp = arr[j];
                     arr[j]= arr[l];
                     arr[l] = temp;
                 }
             }
            
         }
         for(int j=0;arr[j]!=0;j++){
             System.out.print(arr[j]);
             if(arr[j+1]!=0)
             {
                 System.out.print("+");
             }
         }
    }
        
       
    }

