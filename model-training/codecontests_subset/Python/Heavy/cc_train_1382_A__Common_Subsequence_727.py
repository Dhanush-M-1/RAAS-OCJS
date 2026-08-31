t= int(input())
zero= [int (0) for x in range(10)]

for x in range(t):
    cont=0
    n, m= map(int,input().split())
    sub=[int (y) for y in input().split()]
    bb= [int(x) for x in input().split()]
    novalista=[]
    
    if n > m:
        lista1= sub
        lista2= bb
    else:
        lista1= bb
        lista2= sub
    for i in range(len(lista1)):
        if lista1[i] in lista2:
            cont=1
            novalista.append(lista1[i])

    if cont >= 1: 
        print("YES")
        print(cont, novalista[0])
    else:
        print("NO")
#print(*data, sep='')
