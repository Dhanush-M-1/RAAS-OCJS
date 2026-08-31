for _ in range(int(input())):
    n = int(input())
    a = [int(i) for i in input().split()]
    minimum = min(a)
    ind = a.index(minimum)
    nexus = a[ind]
    a[ind] = -1
    maximum = max(a)
    a[ind] = float('inf')
    minimum2 = min(a)
    ind2 = a.index(minimum2)
    ind3 = a.index(maximum)
    a[ind] = nexus
    if a[ind] + a[ind2] <= a[ind3]:
        print(ind + 1, ind2 + 1, ind3 + 1)
    else:
        # print(ind, ind2, ind3)
        print(-1)


