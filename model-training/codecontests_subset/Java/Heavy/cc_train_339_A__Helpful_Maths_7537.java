
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KHALED
 */
public class HelpfulMaths {
    public static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int[]arr,int left,int right)
    {
        int i=left;
        int x=arr[right];
        for(int j=left;j<right;j++)
        {
            if(arr[j]<x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }
    public static int[] QuickWithPivotLast(int[]arr,int left,int right){
        int q;
        if(left<right)
        {
            q=partition(arr, left, right);
            QuickWithPivotLast(arr, left, q-1);
            QuickWithPivotLast(arr, q+1, right);
        }
        return arr;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        Vector<Integer>vec=new Vector<>();
        vec.add(Integer.parseInt(s.charAt(0)+""));
        if(s.length()>1)
        {
            for(int i=2;i<s.length();i+=2)
            {
                vec.add(Integer.parseInt(s.charAt(i)+""));
            }
        }
        int[]arr=new int[vec.size()];
        for (int i = 0; i < vec.size(); i++)
        {
            arr[i]=vec.get(i);
        }
        arr=QuickWithPivotLast(arr, 0, arr.length-1);
        System.out.print(arr[0]);
        if(arr.length>1)
        {
            for (int i = 1; i < arr.length; i++)
            {
                System.out.print("+");
                System.out.print(arr[i]);
            }
        }
        System.out.println("");
    }
}
