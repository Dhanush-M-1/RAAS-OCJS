import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args)throws NumberFormatException,IOException {
               BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
               int q=Integer.parseInt(bf.readLine());
                  int a[]=new int[q];
                  int b[]=new int[q-1];
                  int c[]=new int[q-2];
                  StringTokenizer st=new StringTokenizer(bf.readLine());
                   for (int i = 0; i < a.length; i++) {
                       if(st.hasMoreTokens())
                           a[i]=Integer.parseInt(st.nextToken());
                    
                }
                    st=new StringTokenizer(bf.readLine());
                   
                   for (int i = 0; i < q-1; i++) {
                       if(st.hasMoreTokens()){
                           b[i]=Integer.parseInt(st.nextToken());
                       }
                }
                 
                    
                
                    st=new StringTokenizer(bf.readLine());
                    for (int i = 0; i < q-2; i++) {
                       if(st.hasMoreTokens())
                           c[i]=Integer.parseInt(st.nextToken());
                }
                  boolean t=true;
                   Arrays.sort(a);
                   Arrays.sort(b);
                   Arrays.sort(c);
                   for (int i = 0; i < q-1; i++) {
                        if(a[i]!=b[i])
                            {System.out.println(a[i]);
                            t=false;
                        break;}
                        
                    }
                   if(t)
                       System.out.println(a[a.length-1]);
                   
                 t=true;
                  
                   for (int i = 0; i < q-2; i++) {
                    if(b[i]!=c[i])
                        {System.out.println(b[i]);
                        t=false;
                    break;}
                    
                    }
                  if(t)
                      System.out.println(b[b.length-1]); 
                  
        
                  
                    }
                    
                
                   
                   
                   
                   
    }

