numero = int(input())

lista = input().split()

par = []
impar = []
s = 0
for i in range(len(lista)):
    s += int(lista[i])
    if int(lista[i])%2:
        par.append(int(lista[i]))
    else:
        impar.append(int(lista[i]))

par = sorted(par, reverse = True)
impar = sorted(impar, reverse = True)


ans = 2000000000

for j in range(0, 2):
    k = j
    l = 0
    r = 0
    t = 0
    while(1):
        if k:
            if l == len(par):
                break
            t += par[l]
            l += 1
        else:
            if r == len(impar):
                break
            t += impar[r]
            r += 1
        k = 1-k
    ans = min(ans, s-t)
print(ans)
