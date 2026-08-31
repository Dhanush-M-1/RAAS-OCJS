n = int(input())
lista = []
for i in range(n):
    l, r, d  = input().split()
    l, r, d  = int(l), int(r), int(d)
    h = d
    if(d < l or d > r):
        lista.append(d)
    elif(r == d):
        lista.append(d*2)
    else:
        lista.append(((r//d)+1)*d)
for i in lista:
    print(i)