
import java.util.*;


public class Program
{
	public static void main(String[] args)
	{ 
		Scanner s = new Scanner(System.in);
		int a,b,c,t, t0;
		boolean espera = true;
		a = s.nextInt();;
		b = s.nextInt();;
		c = s.nextInt();;
		
		// verifica se Tamanho x tempo > tempo espera*tamanho baixado
		for (t = 1; a * c > t * b; t++) //while (a * c > t * b) 
		{                 
			espera = true;// define que ainda deve esperar	
			for (t0 = t; t0 <= t + c; t0++) // Tempo apos dar play deve ser menor que o tempo de espera+tempo de video
			{	

				if (t0 * b < (t0 - t) * a)// tempo apos play x velocidade de download < TAD-Tempo espera * tamanho do video				 
				{
					 
					espera = false; // pode dar play no video
                    break;
                }                      
			}
            if (espera)// Escreve tempo minimo necesario de espera
            {
				System.out.println(t);
				break;
            }

            
		}
	
	}


}