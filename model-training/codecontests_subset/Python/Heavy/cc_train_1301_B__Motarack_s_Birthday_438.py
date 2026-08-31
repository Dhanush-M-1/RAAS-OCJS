t = int(input())

for a in range(t):
    menor = 1000000000
    maior = 0
    max_diff = 0
    tam = int(input())
    valores = [int(c) for c in input().split()]

    for i in range(tam):
        if (valores[i] == -1):
            if (i > 0):
                if (valores[i - 1] != -1):
                    menor = min(valores[i-1], menor)
                    maior = max(valores[i-1], maior)
            if (i < tam - 1):
                if (valores[i+1] != -1):
                    menor = min(valores[i+1], menor)
                    maior = max(valores[i+1], maior)
    
    media = (maior + menor) // 2

    for i in range(tam):
        if (valores[i] == -1):
            valores[i] = media
        
    for i in range(0, tam - 1):
        max_diff = max(max_diff, abs(valores[i+1] - valores[i]))
    
    print(max_diff, media)
       	 	 					  	  	 	 					