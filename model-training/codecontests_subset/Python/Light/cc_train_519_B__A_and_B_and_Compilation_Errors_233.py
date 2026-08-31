n = int(input())
L1 = [int(i) for i in input().split()]
L2 = [int(i) for i in input().split()]
L3 = [int(i) for i in input().split()]
L1.sort()
L2.sort()
L3.sort()
k = 0
for i in range(n-1):
    if L1[i] == L2[i]:
        k += 1
    else:
        print(L1[i])
        break
if k == n-1:
    print(L1[n-1])
k = 0
for i in range(n-2):
    if L2[i] == L3[i]:
        k += 1
    else:
        print(L2[i])
        break
if k == n-2:
    print(L2[n-2])
