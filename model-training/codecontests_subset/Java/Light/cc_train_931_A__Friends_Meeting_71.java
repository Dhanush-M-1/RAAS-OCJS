import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FriendsMeeting
{

    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int diff=Math.max(a,b)-Math.min(a,b);
        if(diff%2==0)
            System.out.println((diff/2)*((diff/2)+1));
        else
            System.out.println((int)Math.pow((diff/2)+1,2));
    }
}