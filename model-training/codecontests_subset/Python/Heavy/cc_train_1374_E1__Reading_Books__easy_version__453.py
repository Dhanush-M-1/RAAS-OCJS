line = input()
n, k = [int(i) for i in line.split(' ')]
allL, aliceL, bobL = [], [], []
for i in range(n):
    line = input()
    t, a, b = [int(j) for j in line.split(' ')]
    if a == 1 and b == 1:
        allL.append(t)
    elif a == 1:
        aliceL.append(t)
    elif b == 1:
        bobL.append(t)
allL.sort()
aliceL.sort()
bobL.sort()
# print(allL)
# print(aliceL)
# print(bobL)
if len(allL) + min(len(aliceL), len(bobL)) < k:
    print(-1)
else:
    x = min(len(allL), k)
    b = k - x
    res = sum(allL[:x]) + sum(aliceL[:b]) + sum(bobL[:b])
    while x > 0 and b < min(len(aliceL), len(bobL)):
        x -= 1
        if res <= res - allL[x] + aliceL[b] + bobL[b]:
            break
        else:
            res = res - allL[x] + aliceL[b] + bobL[b]
        b += 1
    print(res)



