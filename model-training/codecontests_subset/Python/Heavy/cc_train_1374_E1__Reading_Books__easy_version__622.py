n, k = map(int, input().split())
lBoth = []
lAlice = []
lBob = []
for i in range(n):
    t, a, b = map(int, input().split())
    if a == 1 and b == 1:
        lBoth.append(t)
    elif a == 1:
        lAlice.append(t)
    elif b == 1:
        lBob.append(t)
if len(lBoth) + min(len(lAlice), len(lBob)) < k:
    print(-1)
else:
    lBob.sort()
    lAlice.sort()
    lBoth.sort()
    numP = 0
    numB = 0
    kol = 0
    tm = 0
    while kol < k:
        if numP == len(lAlice) or numP == len(lBob):
            tm += sum(lBoth[numB:numB + k - kol])
            break
        if numB == len(lBoth):
            tm += sum(lBob[numP:numP + k - kol]) + sum(lAlice[numP:numP + k - kol])
            break
        if lBob[numP] + lAlice[numP] < lBoth[numB]:
            tm += lAlice[numP] + lBob[numP]
            numP += 1
            kol += 1
        else:
            tm += lBoth[numB]
            numB += 1
            kol += 1
    print(tm)
