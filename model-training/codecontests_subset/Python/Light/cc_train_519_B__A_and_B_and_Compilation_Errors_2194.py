n = int(input())
lA = [int(x) for x in input().split()]
lB = [int(y) for y in input().split()]
lC = [int(z) for z in input().split()]
lA.sort()
lB.sort()
lC.sort()
lD = []
flag=0
for i in range(n-1):
    if lA[i] != lB[i]:
        lD.append(lA[i])
        flag=1
        break
if flag==0:
    lD.append(lA[-1])
for k in range(n-1):
    if k == n - 2:
        lD.append(lB[-1])
        break
    if lB[k] != lC[k]:
        lD.append(lB[k])
        break
for j in lD:
    print(j)