a, b = [int(i) for i in input().split()]
horas = 0
apagadas = 0
while a > 0 or apagadas == b:
    if apagadas == b:
        apagadas = 0
        a += 1
    horas += 1
    apagadas += 1
    a += -1

print(horas)