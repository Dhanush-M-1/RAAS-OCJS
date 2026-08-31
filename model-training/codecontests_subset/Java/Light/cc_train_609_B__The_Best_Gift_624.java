import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

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
    public static void main(String[] args) throws IOException 
    {
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tok=new StringTokenizer(reader.readLine());
    int t=Integer.parseInt(tok.nextToken());
    int m=Integer.parseInt(tok.nextToken());
    tok=new StringTokenizer(reader.readLine());
        int arr[]=new int[m];
        for (int i = 0; i < t; i++)
        {
            arr[Integer.parseInt(tok.nextToken())-1]++;
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