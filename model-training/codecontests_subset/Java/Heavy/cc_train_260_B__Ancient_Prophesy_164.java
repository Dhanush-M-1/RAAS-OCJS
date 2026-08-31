import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) 
    {

        
        Scanner scan = new Scanner(System.in);
        //String str = scan.nextLine();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        String text    = scan.nextLine();
              //  "This is the12-12-2013 text which is to be searched " +
                //"for occurrences of the word 'is'.";

        String patternString = "[0-9]{2}[-]{1}[0-9]{2}[-]201[3-5]{1}";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
//      while(matcher.find()) {
//          count++;
//          System.out.println("found: " + count + " : "
//                  + matcher.start() + " - " + matcher.end());
//          if(matcher.start()>1)
//          {
//               matcher.find(2);
//               System.out.println("found: " + count + " : "
//                          + matcher.start() + " - " + matcher.end());
//          }
            
//      }
                
        int l = text.length();
         for(int i = 0;i<l;i++)
         {
             if(matcher.find(i))
             {
//               System.out.println("found: " + count + " : "
//                          + matcher.start() + " - " + matcher.end());
                 i = matcher.end()-3;
                 String st = matcher.group();
                 
                 int m = Integer.valueOf(st.substring(3,5));
                 if(m>0&&m<13)
                 {
                     int d = Integer.valueOf(st.substring(0,2));
                     if(d<=getD(m)&&d>0)
                     {
                         if(map.containsKey(matcher.group()))
                         {
                             int as = map.get(matcher.group());
                             map.put(matcher.group(), as+1);
                         }
                         else
                         {
                             map.put(matcher.group(), 1);
                         }
                     }
                 }
             }
         }
         Iterator it = map.entrySet().iterator();
         int max = 0;
         String maxstr = "";
         while(it.hasNext())
         {
             Map.Entry en = (Map.Entry)it.next();
             if((Integer)en.getValue()>max)
             {
                 max = (Integer)en.getValue();
                 maxstr = (String)en.getKey();
                 
             }
         }
         System.out.print(maxstr);
//      int yl = 10;
//      int yyl = 4;
//      for(int i = l-1;i>=yl;i++)
//      {
//          String sub  = str.substring(i-yyl, i);
//          if(sub.equals("2013")||sub.equals("2014")||sub.equals("2015"))
//          {
//              if(str.charAt(i-yyl-1)=='-');
//              {
//                  String sub2 = str.substring(i-yyl - 3,i-yyl);
//                  if(sub2.indexOf("-")==-1&&Integer.valueOf(sub2)>=1&&Integer.valueOf(sub2)<=12)
//                  {
//                      if(str.charAt(i-yyl-1)=='-');
//                      {
//                          String sub3 = str.substring(i-yyl-3-3,i-yyl-3);
//                      }
//                  }
//              }
//          }
//      }
//      System.out.print(-1);
//       
    }
    private  static int getD(int m)
    {
        switch(m)
        {
            case 1:
                return 31;
            case 2:
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11: 
                return 30;
            case 12:
                return 31;

                
        }
        return 0;
    }
 }







        
        
        
    
    
 
    

