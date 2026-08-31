n = int(input())

impar = []
par = []

l = [int(x) for x in input().split()]
l.sort()
for j in l:
    if j % 2 == 0:
        par.append(j)
    else:
        impar.append(j)

l = min(len(par), len(impar))

par = par[:len(par) - l]
impar = impar[:len(impar) - l]

if len(par) == 0 and len(impar) == 0:
    print(0)
elif len(par) == 0:
    print(sum(impar[:-1]))
elif len(impar) == 0:
    print(sum(par[:-1]))
else:
    if par[-1] >= impar[-1]:
        print(sum(par[:-1]) + sum(impar))
    else:
        print(sum(par) + sum(impar[:-1]))
