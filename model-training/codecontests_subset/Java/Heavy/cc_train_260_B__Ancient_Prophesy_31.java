import java.util.Scanner;


public class Apocalysedate {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        String date = s.next();
        String arr[][] = new String[100000][2];
        int j=0;
        for(int i=0;i<date.length()-9;i++)
        {
            String datesub = date.substring(i,i+10);
        //  System.out.println(datesub);
            int a,b,c;
            char d[] = datesub.toCharArray();
            try {
                a = Integer.parseInt(datesub.substring(0,2));
                b = Integer.parseInt(datesub.substring(3,5));
                c = Integer.parseInt(datesub.substring(6,10));
            } catch (Exception e) {
                // TODO: handle exception
                continue;
            }
            
            //System.out.println(a + " " + b + " " + c);
            int flag=0;
            int z=31;
            if (b==2) z = 28;
            else if(b>=1 && b<=7 && b%2==0) z = 30;
            else if (b >=8 && b<=12 && b%2==1) z = 30;
            if(a >=1 && a<=z && d[2]=='-'  && d[5]=='-' && b>=1 && b<=12 && c>=2013 && c<=2015)
            {
                for (int k = 0; arr[k][0]!=null; k++) {
                    if(arr[k][0].equals(datesub))
                    {
                        
                        int x = Integer.parseInt(arr[k][1]);
                        x++;
                        arr[k][1] = String.valueOf(x);
                    //  System.out.println(datesub + " " + arr[k][1] + " " + x);
                        flag=1;
                    }
                    
                }
                
                if(flag==0)
                {
                    arr[j][0] = datesub;
                    arr[j][1] = "1";
                    j++;
                }
                
                
            }
        
        }
        int max=0;
        int index=0;
        for (int i = 0; arr[i][0]!=null; i++) {
            int y = Integer.parseInt(arr[i][1]);
            if(y>max)
            {
                max = y;
                index = i;
            }
        
        }
        
        System.out.println(arr[index][0]);
        

    }

}
