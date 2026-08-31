placebo = input()
linha = list(map(int,input().split(" ")))
linha_menor = list(map(int,input().split(" ")))
linha_menor_menor = list(map(int,input().split(" ")))
linha.sort()
linha_menor.sort()
linha_menor_menor.sort()
encontrado = -1
encontrado_2 = -1

for i in range(len(linha)):
    if i >= len(linha_menor):
            encontrado = linha[i]
            break
    if linha[i] != linha_menor[i]:
        encontrado = linha[i]
        break

for i in range(len(linha_menor)):
    if i >= len(linha_menor_menor):
            encontrado_2 = linha_menor[i]
            break
    if linha_menor[i] != linha_menor_menor[i]:
        encontrado_2 = linha_menor[i]
        break

print(encontrado)
print(encontrado_2)
			 	  	 	 	  		 				 	  	    	