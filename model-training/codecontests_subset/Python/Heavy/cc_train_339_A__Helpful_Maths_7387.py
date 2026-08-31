suma = input()

p = ''
lista = []
while suma != '':
    c = suma [0]
    if c in ['0','1','2','3','4','5','6','7','8','9']:
        p = p + c
    else:
        lista.append(int(p))
        p = ''
    if len(suma) > 1:
        suma = suma[1:]
    else:
        suma = ''
        lista.append(int(p))

n = len(lista)
i = 0
while i < n - 1:
    j = i + 1
    while j < n:
        if lista[j] < lista[i]:
            aux = lista[j]
            lista[j] = lista[i]
            lista[i] = aux
        j = j + 1
    i = i + 1

k = 0 
nm = ''
for p in lista:
    c = str(p)
    if n > 1:
        if k >= len(lista)-1:
            nm = nm + c
        else:
            nm = nm + c + '+'
    else:
        nm = c
    k = k + 1

print(nm)