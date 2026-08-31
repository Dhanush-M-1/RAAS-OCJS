def missing(lista1, lista2):
    for x in range(len(lista2)):
        if lista1[x] != lista2[x]:
            return lista1[x]
    return lista1[-1]


qtd = int(input())
linha1 = list(map(int, input().split()))
linha1.sort()
linha2 = list(map(int, input().split()))
linha2.sort()
linha3 = list(map(int, input().split()))
linha3.sort()

print(missing(linha1, linha2))
print(missing(linha2, linha3))


 	   				 	   		  		 	 					 		