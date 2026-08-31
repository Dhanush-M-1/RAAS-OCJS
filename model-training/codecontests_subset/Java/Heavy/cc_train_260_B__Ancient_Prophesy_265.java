
import java.util.HashMap;
import java.util.Scanner;

public class AncientProphesy {
    public static void main(String asd[])throws Exception
    {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        int n=s.length();int k=0;int m=0;String max="";
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        HashMap<String,String> hmm=new HashMap<String,String>();
        String a[]={"","31","28","31","30","31","30","31","31","30","31","30","31"};
        for(int i=0;i<n-10+1;i++)
        {
            String r[]=s.substring(i,i+10).split("-");
           // System.out.println(s.substring(i,i+10));
            if(r.length>3 || r.length<3)
                continue;
            else
            {
                if(r[0].length()>=2&&r[1].length()==2 && r[2].length()>=4)
                {
                    String q=r[0].substring(r[0].length()-2,r[0].length());
                    String hh=r[2].substring(0,4);
                    int aa=Integer.parseInt(r[1]);
                    if(aa>=1 && aa<=12)
                    {
                        if(q.compareTo("00")>0&&q.compareTo(a[aa])<=0 && hh.compareTo("2013")>=0 && hh.compareTo("2015")<=0)
                        {
                            String f=q+"-"+r[1]+"-"+hh;
                            if(hm.get(f)==null)
                            {
                                hm.put(f,1);
                            }
                            else 
                                hm.put(f,hm.get(f)+1);
                            if(hm.get(f)>m)
                            {
                                m=hm.get(f);
                                max=f;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
