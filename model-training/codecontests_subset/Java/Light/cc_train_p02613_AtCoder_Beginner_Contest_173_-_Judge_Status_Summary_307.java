import java.util.*; 
class Main 
{
public static void main(String args[]) 
{
Scanner sc = new Scanner(System.in); 
int n = Integer.parseInt(sc.nextLine()); 
int AC=0,WA=0,TLE=0,RE=0;
while(n-->0) 
{
String s = sc.nextLine(); 
if(s.equals("AC")) 
{
AC++;
} 
else if(s.equals("WA")) 
{
WA++;
} 
else if(s.equals("TLE")) 
{
TLE++;
} 
else 
{
RE++;
}
} 
System.out.println("AC x "+AC); 
System.out.println("WA x "+WA); 
System.out.println("TLE x "+TLE); 
System.out.println("RE x "+RE);
} 
}