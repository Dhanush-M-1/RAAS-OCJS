t = int(input())

for w in range(t):
    n = int(input())
    p = [int(i) for i in input().split()]

    g, s, b = 0, 0, 0

    mid = n // 2
    if mid < 3:
        print(g, s, b)
        continue

    maxG = max(p)
    lastGoldInx = -1
    lastSilverInx = -1
    check = []
    repeatNum = 0

    for i in range(mid):
        check.append(p[i])

    check = list(set(check))

    if len(check) == 1 or len(check) == 2:
        print(g, s, b)
        continue

    for i in range(mid):
        if p[i] == maxG:
            g += 1
            lastGoldInx = i
        else:
            break

    maxS = p[lastGoldInx + 1]

    for i in range(lastGoldInx + 1, mid):
        if p[i] == maxS or s < g + 1:
            s += 1
            lastSilverInx = i

    if p[lastSilverInx + 1] == p[lastSilverInx]:
        repeatNum = p[lastSilverInx]

    for i in range(lastSilverInx + 1, mid):
        if p[i] == repeatNum:
            s += 1
            lastSilverInx = i
        else:
            break

    if p[mid - 1] == p[mid]:
        repeatNum = p[mid - 1]

    for i in range(lastSilverInx + 1, mid):
        if p[i] != repeatNum:
            b += 1

    if (b == 0 or s == 0 or g == 0) or (b <= g) or (s <= g):
        print(0, 0, 0)
    else:
        print(g, s, b)
