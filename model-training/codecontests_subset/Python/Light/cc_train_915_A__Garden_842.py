n, k = [int(i) for i in input().split()]
baldes = [int(i) for i in input().split()]

lista = []

for i in baldes:
    if k%i == 0:
        lista.append(k//i)

lista.sort()
print(lista[0])
 	 			 		   		  	  		      		 	