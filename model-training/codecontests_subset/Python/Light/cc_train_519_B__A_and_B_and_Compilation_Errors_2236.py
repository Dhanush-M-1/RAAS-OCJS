n = int(input())

lista1 = list(map(int, input().split(" ")))
lista2 = list(map(int, input().split(" ")))
lista3 = list(map(int, input().split(" ")))

lista1.sort()
lista2.sort()
lista3.sort()

r1 = 0
r2 = 0

for i in range(n):
    if not r1:
        if i == len(lista2):
            r1 = lista1[i]
        else:
            if lista1[i] != lista2[i]:
                r1 = lista1[i]
    
    if not r2:
        if i == len(lista3):
            r2 = lista2[i]
        else:
            if lista2[i] != lista3[i]:
                r2 = lista2[i]
    
    if r1 and r2:
        break

print(r1)
print(r2)
		 			  		    	 				  		  	  	