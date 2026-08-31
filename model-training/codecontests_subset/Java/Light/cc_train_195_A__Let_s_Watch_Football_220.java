import java.util.Scanner;

public class Main {

     
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int Ds = s.nextInt();
        
        int Vm=s.nextInt();
        int T=s.nextInt();
        Ds*=T;
        double tr=(double)(Ds-T*Vm)/Vm-(int)(Ds-T*Vm)/Vm;
        int t=(int)(Ds-T*Vm)/Vm;
        if(tr>0)
        {
           t++;
        }
        System.out.println(t); 
    }
 
}