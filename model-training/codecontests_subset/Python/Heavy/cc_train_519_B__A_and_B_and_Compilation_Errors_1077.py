n = int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]

aDict = {}
bDict = {}
cDict = {}
for i in a:
    if i in aDict:
        aDict[i] += 1
    else:
        aDict[i] = 1
for i in b:
    if i in bDict:
        bDict[i] += 1
    else:
        bDict[i] = 1
for i in c:
    if i in cDict:
        cDict[i] += 1
    else:
        cDict[i] = 1
for i in a:
    if (i not in bDict) or bDict[i] == 0:
        print(i)
    else:
        bDict[i] -= 1
for i in b:
    if (i not in cDict) or cDict[i] == 0:
        print(i)
    else:
        cDict[i] -= 1