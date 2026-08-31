import java.io.*;
import java.util.*;
public class string{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String arr[] = a.split("\\+");
        int arr1[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
                arr1[i] = Integer.parseInt(arr[i]);
        for(int i=0;i<arr1.length-1;i++){
            for(int j=0;j<arr1.length-i-1;j++){
                if(arr1[j]>arr1[j+1]) {
                    int temp = arr1[j];
                    arr1[j]=arr1[j+1];
                    arr1[j+1]=temp;
                }
            }
        }
        String str="";
        for(int i=0;i<arr1.length-1;i++)
                str = str +arr1[i]+ "+";
        str=str+arr1[arr1.length-1];
        System.out.println(str);
        
    }
}