totalBaldes, tamJardim = [int(i) for i in input().split()]
baldes = [int(i) for i in input().split()]

# pegar o balde cuja capacidade é o maior divisor do tamanho do jardim
baldeEscolhido = 0
for i in baldes:
    if tamJardim % i == 0 and i > baldeEscolhido:
        baldeEscolhido = i

print(tamJardim//baldeEscolhido)
		 	 	  	 	 	  	   	 		 	 				