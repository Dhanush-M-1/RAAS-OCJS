for _ in range(int(input())):
    n = int(input())
    point = list(map(int, input().split()))
    gold = 1
    bronze = 1
    silver = 1
    best = 0
    while gold < n:
        if point[gold] != point[gold - 1]:
            break
        gold += 1
    silver = gold + 1
    while gold + silver < n - 1:
        if point[gold + silver - 1] != point[gold + silver]:
            break
        silver += 1
    bronze = gold + 1
    while gold + silver + bronze < n - 1:
        if point[gold + silver + bronze - 1] != point[gold + silver + bronze]:
            break
        bronze += 1

    if gold + silver + bronze > n // 2:
        bronze = silver = gold = 0
    else:
        src = n // 2 - 1
        while point[src] == point[src + 1]:
            src -= 1
        bronze = src + 1 - gold - silver

    print(gold, silver, bronze)



