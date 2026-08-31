import java.util.Scanner;
public class Main {

    public static void main(String[] args) 
    {
        /*53 *.*.****.*.*......**....**.***.*.*.**.*.*.***...*..*.*/
        Scanner s=new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        String str=s.nextLine();
        String o[]=str.split("");
        boolean bool=true;
        int elementos=n;
        int con=0;
        int j=0;
        while(j<n && bool)
        {
            if(o[j].compareTo(".")==0)
            {
                con++;
            }
            else
            {
                bool=false;
            }
            j++;
        }
        elementos-=con;
        con=0;
        j=n-1;
        while(j>=0 && bool)
        {
            if(o[j].compareTo(".")==0)
            {
                con++;
            }
            else
            {
                bool=false;
            }
            j--;
        }
        elementos-=con;
        int saltos=0;
        bool=false;
        for (int i = 0; i < n; i++) 
        {
            if(o[i].compareTo(".")!=0)
            {
                saltos=elementos/4;
                
                for (int k = 1; k <= saltos; k++) 
                {
                    if(i+(4*k)<n&&o[i+k].compareTo("*")==0 && o[i+(2*k)].compareTo("*")==0&& o[i+(3*k)].compareTo("*")==0&& o[i+(4*k)].compareTo("*")==0 )
                    {
                        System.out.println("yes");
                        i=1000;
                        k+=1000;
                        bool=true;
                    }
                }
            }
        }
        if(!bool)
        {
            System.out.println("no");
        }
    }
}
