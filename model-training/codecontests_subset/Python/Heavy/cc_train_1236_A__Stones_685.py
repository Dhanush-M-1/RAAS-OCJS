cases = int(input())
def op1(lista, izq, der):
    recolected = 0
    while(lista[izq] >= 1 and lista[der] >= 2):
        #print(lista)
        recolected += 1
        lista[izq] -= 1
        lista[der] -= 2
    return recolected

for i in range(cases):
    stones = list(map(int, input().split()))
    major = stones[1:]
    menor = min(major)
    menor = stones.index(menor)
    major = max(major)

    major = stones.index(major)

    counter = op1(stones, 1, 2)
    counter += op1(stones, 0, 1)


    if op1(stones, 0, 1) + op1(stones, 1, 2) > counter:
        counter = op1(stones, 0, 1) + op1(stones, 1, 2)

    print(counter * 3)