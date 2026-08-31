for i in range(int(input())):
    largo = int(input())
    lista = [int(j) for j in input().split()]
    solved = 0
    minimo = lista[0]
    maximo = lista[largo - 1]
    for x in range(1, largo - 1):
        if lista[x] + minimo <= maximo:
            print(1, x + 1, largo)
            solved = 1
            break
    if solved == 0:
        print(-1)