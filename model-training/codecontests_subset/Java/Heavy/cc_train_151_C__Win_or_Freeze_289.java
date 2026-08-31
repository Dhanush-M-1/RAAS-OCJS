    import java.util.*;
    import java.lang.*;
     
    public class Main{
        public static void main(String [] args)
        {
            Scanner scan=new Scanner(System.in);
            long q=scan.nextLong();
            Stack<Long> st =new Stack<>();
            
            for(long i=2 ; i*i <=q;i++)
            {
                if(q%i==0)
                {
                    q /=i;
                    st.push(i);
                    i=1;
                }
            }
           
            if(st.size()==0)
            {
                System.out.println(1);
                System.out.println(0);
            }
            else if(st.size()==1)
            {
                System.out.println(2);
            }
            else
            {
                System.out.println(1);
                System.out.println(st.pop()*q);
            }
        }
    }