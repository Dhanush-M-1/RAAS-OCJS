def erro(erros1, erros2):
    mapa1 = {}
    mapa2 = {}
    
    for e in erros1:
        if e in mapa1.keys():
            mapa1[e] += 1
        else:
            mapa1[e] = 1
            
    for e in erros2:
        if e in mapa2.keys():
            mapa2[e] += 1
        else:
            mapa2[e] = 1
            
    for e in mapa1.keys():
        if e in mapa2.keys():
            if mapa1[e] > mapa2[e]:
                return e
        else:
            return e
    

n = int(input())
erros1 = input().split()
erros2 = input().split()
erros3 = input().split()

print(erro(erros1, erros2))
print(erro(erros2, erros3))
 			 							 	  		  		   	  	