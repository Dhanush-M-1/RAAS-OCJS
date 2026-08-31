def funcao(l, r, d):
    if d < l or d > r:
        return d
    else:
        m = int(r / d)
        return (m + 1) * d

q = int(input())
lista = []
for e in range(q):
    lista.append(input().split())

for e in lista:
    l = int(e[0])
    r = int(e[1])
    d = int(e[2])
    print(funcao(l, r, d))
 	 			   	 	 			      	  		  	