def getSum(n, arr):
    eveAr = []
    oddAr = []
    for i in arr:
        if i % 2 == 0:
            eveAr.append(i)
        else:
            oddAr.append(i)
    eN = len(eveAr)
    oN = len(oddAr)
    eveAr.sort()
    oddAr.sort()
    if eN - oN > 1:
        s = eN - oN - 1
        res = sum(eveAr[:s])
    elif oN - eN > 1:
        s = oN - eN - 1
        res = sum(oddAr[:s])
    else:
        return 0
    return res



n = int(input())
arr = list(map(int, input().split()))
print(getSum(n, arr))
