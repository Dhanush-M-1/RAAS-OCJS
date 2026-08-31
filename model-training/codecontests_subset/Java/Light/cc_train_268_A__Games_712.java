import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{




public static void main(String []args) throws IOException {
        
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(in.readLine().trim());
    int [][]arr=new int[t][2];
    for(int i=0;i<t;i++)
    {
    String Line=in.readLine();
    arr[i][0]=Integer.parseInt(Line.split("\\s+")[0]);
    arr[i][1]=Integer.parseInt(Line.split("\\s+")[1]);
    }

    int count=0;
    for(int i=0;i<t;i++)
    for(int j=0;j<t;j++)
        {    
            if(i==j)
            continue;
            if(arr[i][0]==arr[j][1])
            count++;
    
    }
    
    System.out.println(count+"");
    


}

}


















