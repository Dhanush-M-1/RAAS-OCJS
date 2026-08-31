        import java.util.*;
public class asd
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int l=s.nextInt();
        int r=s.nextInt();int end=0;
        if((r-l+1)>4||((l%2)!=(r%2))||((l%2)==(r%2)&&((l%2)==0)))
        end=2;

        else
        end=l;
        System.out.println(end);
    }
}