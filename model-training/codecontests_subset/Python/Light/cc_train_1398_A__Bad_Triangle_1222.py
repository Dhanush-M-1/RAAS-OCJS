N = int(input())
LIS = [0 for i in range (N)]
for j in range(N):
    x = int(input())
    listik = [int(i) for i in input().split()]
    if ((listik[0] + listik[1]) <= listik[x-1]):
            LIS[j] = [1,2,x]
    else: LIS[j] = [-1]

for lis in LIS:
    lis = [str(i) for i in lis]
    print(' '.join(lis))