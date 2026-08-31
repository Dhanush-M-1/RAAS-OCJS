def solve():
    n, mediana_final = [int(x) for x in input().split(' ')]
    lista = [int(x) for x in input().split(' ')]
    lista.sort()
    i = n//2 
    mediana = lista[i]

    res = abs(mediana-mediana_final)

    if n==1:
        return res

    if mediana < mediana_final:
        i += 1
        while lista[i] < mediana_final:
            res += abs(lista[i] - mediana_final)
            i += 1
            if i == n:
                return res

    else:
        i -= 1
        while lista[i] > mediana_final:
            res += abs(lista[i] - mediana_final)
            i -= 1
            if i == -1:
                return res

    return res

print(solve())

	 	   		  	 	 		    					 				