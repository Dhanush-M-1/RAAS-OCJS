/* package whatever; // don't place package name! */
 
import java.util.*;
import java.math.BigInteger; 
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
/* Name of the class has to be "Main" only if the class is public. */
public class bbg
{
	public static int result;
 
public static ArrayList<Integer> [] graph;
 
public static int[]cats;
 public static String[]vector;
 
 
public static int vizitat[];
public static int x;
//public static HashMap<String, Integer> map2;
 
 
	public static void main (String[] args) throws IOException {
 
Scanner input = new Scanner(System.in);
 
HashMap<Integer, Integer> contor1= new HashMap<Integer, Integer>();
HashMap<Integer, Integer> contor2= new HashMap<Integer, Integer>();
 
 
HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
HashMap<String, Integer> litere= new HashMap<String, Integer>();
HashMap<String, Integer> combinari= new HashMap<String, Integer>();
 
 
litere.put("a",1);
litere.put("b",2);
litere.put("c",3);
litere.put("d",4);
litere.put("e",5);
litere.put("f",6);
litere.put("g",7);
litere.put("h",8);
litere.put("i",9);
litere.put("j",10);
litere.put("k",11);
litere.put("l",12);
litere.put("m",13);
litere.put("n",14);
litere.put("o",15);
litere.put("p",16);
litere.put("q",17);
litere.put("r",18);
litere.put("s",19);
litere.put("t",20);
litere.put("u",21);
litere.put("v",22);
litere.put("w",23);
litere.put("x",24);
litere.put("y",25);
litere.put("z",26);




 BigInteger numar_initial; 
 BigInteger primul; 
 BigInteger doilea;
  BigInteger produs;
  BigInteger unitatea;
  


 
int teste=input.nextInt();
for (int t=1; t<=teste;t++)
{
//Scanner scan = new Scanner(System.in);
 // int n=input.nextInt();
 //Scanner scan = new Scanner(System.in);

//String str=input.next();


           //  StringBuilder stro  = new StringBuilder(scan.nextLine());
          //   stro  = new StringBuilder(scan.nextLine());
          //   String str=String.valueOf(stro);
             
            //  StringBuilder raspunsul    = new StringBuilder(); 
     
     
    
//System.out.println(i+" " + str.substring(i,i+1));
 
 
// System.out.println(i+" " + litere.get(str.substring(i,i+1)));



// System.out.println(min);
//System.out.println(max);
//}





//}

int a=input.nextInt();
int b=input.nextInt();
int c=input.nextInt();
int a1=a;
int b1=b;
int c1=c;



int raspuns=0;
int raspuns2=0;

int minimul=Math.min(a,b/2);
//System.out.println(minimul);
if (minimul*2>b) minimul--;

raspuns+=3*minimul;
b=b-minimul*2;

minimul=Math.min(b,c/2);
raspuns+=3*minimul;

//System.out.println(raspuns);

int minimul2=Math.min(b1,c1/2);
//System.out.println("min b c=" + minimul2);
if (minimul2*2>c1) minimul2--;

raspuns2+=3*minimul2;
c1=c1-minimul2*2;
b1-=minimul2;

minimul2=Math.min(a1,b1/2);
if (minimul2*2>b1) minimul2--;
//System.out.println("min a b=" + minimul2);

raspuns2+=3*minimul2;
//System.out.println(raspuns2);

System.out.println(Math.max(raspuns,raspuns2));

}














}



  


}
