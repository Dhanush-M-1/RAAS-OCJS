"""
Nome: Stefano Lopes Chiavegatto
RA: 1777224
"""

num_tam = input()
baldes = input()

lista_num_tam = num_tam.split(" ")
tam = int(lista_num_tam[1])

lista_baldes = baldes.split(" ")

tam_baldes = [tam/int(i) for i in lista_baldes if (tam%int(i) == 0)]

print(int(min(tam_baldes)))
 	  	   	 			 	  	  	 	 		 				