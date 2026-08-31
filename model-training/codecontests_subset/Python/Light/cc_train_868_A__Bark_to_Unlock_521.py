pw = input()
n = int(input())
lista = []
aux = 0

for i in range(n):
    lista.append(input())

for i in lista:
    if pw[0] or pw[1] in i:
        for j in lista:
            if pw[0] or pw[1] in j:
                item = i+j
                if item.count(pw) > 0:
                    aux = 1
                    print("YES")
                    break

    if aux == 1:
        break

if aux == 0:
    print("NO")