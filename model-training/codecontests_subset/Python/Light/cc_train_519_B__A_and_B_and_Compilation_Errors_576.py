def funcao(lista1, lista2):
    i = 0
    while i < len(lista2):
        if lista1[i] != lista2[i]:
            return lista1[i]
        i += 1
    return lista1[len(lista1) - 1] 

input()
lista1 = list(map(int, input().split()))
lista1.sort()
lista2 = list(map(int, input().split()))
lista2.sort()
lista3 = list(map(int, input().split()))
lista3.sort()

print(funcao(lista1, lista2))
print(funcao(lista2, lista3))
