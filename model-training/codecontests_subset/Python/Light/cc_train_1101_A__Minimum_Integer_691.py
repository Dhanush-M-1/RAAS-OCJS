entrada1 = int(input())
entrada2 = []
listaX = []
q = entrada1

for i in range(entrada1):
    entrada2.append(input().split())


def calcular_x(ele, r, d):
    x = 0
    if d < ele:
        x = d
    else:
        x = int(r/d)*d + d
    return x

for i in range(q):
    listaX.append(calcular_x(int(entrada2[i][0]), int(entrada2[i][1]), int(entrada2[i][2])))

for elemento in listaX:
    print(elemento)
