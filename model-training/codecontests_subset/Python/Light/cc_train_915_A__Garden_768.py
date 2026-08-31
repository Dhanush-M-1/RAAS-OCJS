entrada = [int(x) for x in input().split()]
baldes = entrada[0]
tamanho = entrada[1]
quantidade = [int(x) for x in input().split()]
final = 0

for i in quantidade:
    if tamanho % i == 0:
        if i > final:
            final = i

resultado = tamanho // final
print(resultado)
					  		 	 	 		 	 	   		    	