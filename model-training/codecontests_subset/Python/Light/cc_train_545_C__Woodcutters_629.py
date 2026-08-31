cont = 2

n = int(input())

tre = []

for i in range(n):
    a, b = map(int, input().split())
    tre.append((a, b))

anterior = tre[0][0]

for i in range(1, n-1):
    atual = tre[i]
    if(atual[0] - atual[1] > anterior):
        cont += 1
        anterior = atual[0]
    elif(atual[0] + atual[1] < tre[i+1][0]):
        cont += 1
        anterior = atual[0] + atual[1]
    else:
        anterior = atual[0]
if(n == 1):
    cont -=1
print(cont)
