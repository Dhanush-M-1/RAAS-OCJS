import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Twins
 */
public class TheBestGift
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int m=sc.nextInt();
        int arr[]=new int[m];
        for (int i = 0; i < t; i++)
        {
            arr[sc.nextInt()-1]++;
        }
        int count=0;int sum=0;
        for (int i = 0; count<m; i++)
        {
            if (i+1==m)
            {
                i=count;
                count++;continue;
            }
            sum+=arr[i+1]*arr[count];
        }
        System.out.println(sum);
    }
    
}