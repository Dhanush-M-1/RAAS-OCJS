import java.util.*;
public class killer
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        String str1=ob.next();
        String str2=ob.next();
        int day=ob.nextInt();
        String list[][]=new String[2][day+1];
        list[0][0]=str1;
        list[1][0]=str2;
        String dead[]=new String[day];
        String replace[]=new String[day];
        int i;
        for(i=0;i<day;i++)
        {
            dead[i]=ob.next();
            replace[i]=ob.next();
        }
        for(i=0;i<day;i++)
        {
            if(dead[i].equals(list[0][i]))
            {
                list[0][i+1]=replace[i];
                list[1][i+1]=list[1][i];
            }
            else
            {
                list[1][i+1]=replace[i];
                list[0][i+1]=list[0][i];
            }
        }
        for(i=0;i<day+1;i++)
        {
            System.out.println(list[0][i]+" "+list[1][i]);
        }
    }
}