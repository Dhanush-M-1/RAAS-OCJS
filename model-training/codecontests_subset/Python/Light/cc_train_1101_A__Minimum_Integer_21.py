q = int(input())

for i in range(q):
    entrada = list(map(int,input().split()))
    
    if (entrada[2]) < (entrada[0]):
       print(entrada[2])
    else:
        saida = ((entrada[1]) // (entrada[2]) + 1)
        print(saida*(entrada[2]))
    				 		  		  		 		       		