def gcd(x, y):
    while y != 0:
        (x, y) = (y, x % y)
    return x

qntdtipos = int(input())

lista = [int(x) for x in input().split()]

lista.sort()
conta = lista[qntdtipos-1] - lista[0]

for k in range(1, qntdtipos):
    if lista[k] != lista[qntdtipos-1]:
        conta = gcd(conta, lista[qntdtipos-1] - lista[k])

numladroes = 0
for k in range(qntdtipos):
    if lista[k] != lista[qntdtipos-1]:
        numladroes += int((lista[qntdtipos-1] - lista[k])/conta)
print("{} {}".format(numladroes, conta), end = "")
