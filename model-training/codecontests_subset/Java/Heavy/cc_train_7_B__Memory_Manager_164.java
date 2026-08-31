import java.util.Scanner;
public class Main {
    static int arreglo[],n;
    static int identificador=1;
    public static void main(String[]args)
    {
        Scanner e=new Scanner(System.in);
        int op=e.nextInt();
        n=e.nextInt();
        arreglo=new int[n];
        e.nextLine();
        for(int p=0;p<op;p++)
        {
            String s=e.nextLine();
            String all[]=s.split(" ");
            if(all[0].equals("alloc"))
            {
                if(Integer.parseInt(all[1])>0)
                    aloquear(Integer.parseInt(all[1]));
                else
                    System.out.println("NULL");
            }
            else if(all[0].equals("erase"))
            {
                if(Integer.parseInt(all[1])>0)
                    borrar(Integer.parseInt(all[1]));
                else
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
            }
            else
            {
                sort();
            }

        }
    }
    public static boolean nohayNada(int a,int b){
        for(int i=a;i<=b;i++)
            if(arreglo[i]!=0)
                return false;
        return true;
    }
    public static void aloquear(int n)
    {
        boolean encontro=false;
        for(int i=0;i<arreglo.length;i++)
        {
            if(i+n-1<arreglo.length&&nohayNada(i,i+n-1))
            {
                for(int j=i;j<i+n&&j<arreglo.length;j++)
                {
                    arreglo[j]=identificador;
                }
                encontro=true;
            }
            if(encontro)
                break;
        }
        if(encontro)
        {
            System.out.println(identificador);
            identificador++;
        }
        else
        {
            System.out.println("NULL");
        }
    }
    public static void borrar(int n)
    {
        boolean encontro=false;
        for(int i=0;i<arreglo.length;i++)
        {
            if(arreglo[i]==n)
            {
                for(int j=i;j<arreglo.length;j++)
                {
                    if(arreglo[j]==n)
                        arreglo[j]=0;
                    else
                        break;
                }
                encontro=true;
            }
            if(encontro)
                break;
        }
        if(!encontro)
            System.out.println("ILLEGAL_ERASE_ARGUMENT");
    }
    public static void sort()
    {
        int indAct=0;
        String st="";
        for(int i=0;i<arreglo.length;i++)
        {
            if(arreglo[i]!=0)
                st+=(arreglo[i]+" ");
        }
        int xy=arreglo.length;
        String sp[]=st.split(" ");
        arreglo=new int[n];
        for(int i=0;i<sp.length;i++)
        {
            if(!sp[i].equals(""))            
                arreglo[i]=Integer.parseInt(sp[i]);
        }
    }

}
